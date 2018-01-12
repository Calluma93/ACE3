import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		int framelocation =0;
		int numIn =0;	
		int value = 0;
		int framecounter = 0;
		int frameno =0;
		
		FileWriter filewriter = new FileWriter("C:\\Users\\callu\\workspace\\ACE3\\src\\output.txt");
		PrintWriter fileprint = new PrintWriter(filewriter);
		
		readDisk backingStore = new readDisk();
		pageTable pagetable = new pageTable();
		physicalMemory physicalmem = new physicalMemory();
		
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\callu\\workspace\\ACE3\\src\\InputFile.txt"));	
			
			while (sc.hasNextInt()) {
				
				numIn = sc.nextInt();
				
				int offset = numIn & 0xFF;
				int pageno = ((numIn >> 8) & 0xFF);				
				
			
				//tlb
				
				//page table
				frameno = pagetable.tableSearch(pageno);
				if (frameno != -1){		 

					 value = physicalmem.getByte(frameno, offset);
					 
				}				
				
				
				//disk
				else {
				framelocation = (pageno*256);
				byte[] framefrombackingstorage = backingStore.read(framelocation);				
				pagetable.tableInsert(framecounter, pageno);
				physicalmem.insert(framefrombackingstorage, framecounter);
				value = framefrombackingstorage[offset];
				frameno=framecounter;
				framecounter++;
				}
		
	fileprint.println("Virtual address: " + numIn + " Physical address: " + ((256 * frameno)+ offset) + " Value: " + value);
			//frameno=-1;
			
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

}

