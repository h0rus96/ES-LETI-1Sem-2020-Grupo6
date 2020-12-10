package data_service.CodeSmells;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
/**
* FindFile is a class to facilitate the opening of the excel file through a quick time without having to include it to our project or knowing its directory.
* 
* 
* @author jffss-iscte
* 
*/
public class FindFile {

    private static final File   POISONPILL  = new File("");

    private static class RunnableDirSearch implements Runnable {
    	
    	/**
    	 * queue of directories
    	 */
    	
    	private final BlockingQueue<File>   dirQueue;
    	
    	/**
    	 * queue of files
    	 */
    	
        private final BlockingQueue<File>   fileQueue;
        
        /**
    	 * Counter .
    	 */
        
        private final AtomicLong            count;
        
        /**
    	 * Limiting number.
    	 */
        
        private final int                   num;

        public RunnableDirSearch(final BlockingQueue<File> dirQueue, final BlockingQueue<File> fileQueue, final AtomicLong count, final int num) {
            this.dirQueue = dirQueue;
            this.fileQueue = fileQueue;
            this.count = count;
            this.num = num;
        }
        /**
    	 * <p>Put elements to the queue.
    	 * </p>
    	 * 
    	 *
    	 */
        @Override
        public void run() {
            try {
                File dir = dirQueue.take();
                while (dir != POISONPILL) {
                    final File[] fi = dir.listFiles();
                    if (fi != null) {
                        for (final File element : fi) {
                            if (element.isDirectory()) {
                                count.incrementAndGet();
                                dirQueue.put(element);
                            } else {
                                fileQueue.put(element);
                            }
                        }
                    }
                    final long c = count.decrementAndGet();
                    if (c == 0) {
                        end();
                    }
                    dir = dirQueue.take();
                }
            } catch (final InterruptedException ie) {
                // file found or error
            }
        }
        /**
    	 * <p>end the insertion into the queue.
    	 * </p>
    	 * 
    	 *
    	 */
        private final void end() {
            try {
                fileQueue.put(POISONPILL);
            } catch (final InterruptedException e) {
                // empty
            }
            for (int i = 0; i < num; i++) {
                try {
                    dirQueue.put(POISONPILL);
                } catch (final InterruptedException e) {
                    // empty
                }
            }
        }
    }

    /**
    * SourceCode is an object to identify and specify the parameters of the piece of code were studying.
    * 
    * 
    * @author jffss-iscte
    * 
    */
    
    private static class CallableFileSearch implements Callable<File> {
       
    	/**
    	 * queue of directories
    	 */
    	
    	private final BlockingQueue<File>   dirQueue;
        
    	/**
    	 * queue of files.
    	 */
    	
    	private final BlockingQueue<File>   fileQueue;
        
    	/**
    	 * name of the file
    	 */
    	
    	private final String                name;
        
    	/**
    	 * number of processes running.
    	 */
    	
    	private final int                   num;

        public CallableFileSearch(final BlockingQueue<File> dirQueue, final BlockingQueue<File> fileQueue, final String name, final int num) {
            this.dirQueue = dirQueue;
            this.fileQueue = fileQueue;
            this.name = name;
            this.num = num;
        }

        /**
    	 * <p>Take files from the queue.
    	 * </p>
    	 * 
    	 *
    	 */
        
        @Override
        public File call() throws Exception {
            File file = fileQueue.take();
            while (file != POISONPILL) {
                final String filename = file.getName().toLowerCase();
                final String lf = name.toLowerCase();
                if (filename.equalsIgnoreCase(name) || filename.startsWith(lf) || filename.endsWith(lf)) {
                    end();
                    return file;
                }
                file = fileQueue.take();
            }
            return null;
        }

        /**
    	 * <p>Ends the insertion into the queue
    	 * </p>
    	 * 
    	 *
    	 */
        
        private final void end() {
            for (int i = 0; i < num; i++) {
                try {
                    dirQueue.put(POISONPILL);
                } catch (final InterruptedException e) {
                    // empty
                }
            }
        }
    }
    
    /**
	 * name of the file
	 */
    
    private final String        filename;
   
    /**
	 * base directory of the file
	 */
    
    private final File          baseDir;
  
    /**
	 * number of processes running.
	 */
    
    private final int           concurrency;
    
    /**
	 * counter
	 */
    
    private final AtomicLong    count;

    public FindFile(final String filename, final File baseDir, final int concurrency) {
        this.filename = filename;
        this.baseDir = baseDir;
        this.concurrency = concurrency;
        count = new AtomicLong(0);
    }

    /**
	 * <p>Finds the file.
	 * </p>
	 * @return The file we want to find
	 *
	 */
    
    public File find() {
        final ExecutorService ex = Executors.newFixedThreadPool(concurrency + 1);
        final BlockingQueue<File> dirQueue = new LinkedBlockingQueue<File>();
        final BlockingQueue<File> fileQueue = new LinkedBlockingQueue<File>(10000);
        for (int i = 0; i < concurrency; i++) {
            ex.submit(new RunnableDirSearch(dirQueue, fileQueue, count, concurrency));
        }
        count.incrementAndGet();
        dirQueue.add(baseDir);
        final Future<File> c = ex.submit(new CallableFileSearch(dirQueue, fileQueue, filename, concurrency));
        try {
            final File f = c.get();
            return f;
        } catch (final Exception e) {
            return null;
        } finally {
            ex.shutdownNow();
        }
    }
   
    /**
	 * <p>Gets the directory of the file we want to find.
	 * </p>
	 * @return the directory of the file
	 *
	 */
    
    public String getDir() {
         final FindFile ff = new FindFile(filename, baseDir, 6);
         final File f = ff.find();
         return f.toString();
    	
    }
    
}
