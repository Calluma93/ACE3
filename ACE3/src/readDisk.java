import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class readDisk {
	
	public byte[] read(int frameLocation){
		byte[] frame = new byte[256];
	File fileName;
 	RandomAccessFile disk = null;

	try {
           fileName = new File("BACKING_STORE");
           disk = new RandomAccessFile(fileName, "rw");

		// seek to location of frame
		disk.seek(frameLocation);

		for (int i = 0; i < 256; i++) {
			frame[i] = (byte) disk.read();
		}
	}
		   catch (IOException e) {
               System.err.println ("Unable to start the disk");
               System.exit(1);
          }
		finally {
			try {
				disk.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	return frame;
	}
}
