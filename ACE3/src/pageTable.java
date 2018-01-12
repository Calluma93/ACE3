
public class pageTable {
	
int[] frameNos = new int[256];


	public pageTable(){
		
	for (int i = 0; i < frameNos.length; i++){

	frameNos[i] = -1;
	}
	}
	
public int tableSearch(int pageno) {
	return frameNos[pageno];		
}	
	
public void tableInsert(int virtualAddress, int pageno) {
			
			frameNos[pageno] = virtualAddress;
			return;
}

}
