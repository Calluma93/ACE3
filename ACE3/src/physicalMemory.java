
public class physicalMemory {

	byte[][] frame = new byte[256][256];
	
	public byte getByte(int frameno, int offset){
		return frame[frameno][offset];
		
	}
	
	public void insert(byte[] frametobeinserted, int framecounter){
		
	for(int i = 0; i < frametobeinserted.length; i++){ ;
		frame[framecounter][i] = frametobeinserted[i];
	}
	
	}
	
}
