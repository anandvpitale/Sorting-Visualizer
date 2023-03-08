	package Sortings;
	import java.awt.EventQueue;
	import javax.swing.JFrame;
	import javax.swing.JTextField;
	import javax.swing.JLabel;
	//import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JTextArea;
	import java.awt.Font;
	import java.awt.Color;
	import java.awt.Desktop;
	
	//import java.awt.Desktop;
	//import java.io.File;
	//import java.io.IOException;

    class quiks
    {
         void quickSort(int[] num, int start, int end)
         {
            int partition = partition(num, start, end);
            if(partition-1>start)
            {
                quickSort(num, start, partition - 1);
            }
             if(partition+1<end)
            {
                quickSort(num, partition + 1, end);
            }
         }

             int partition(int[] num, int start, int end){
                 int pivot = num[end];

                 for(int i=start; i<end; i++){
                    if(num[i]<pivot){
                    int temp= num[start];
                    num[start]=num[i];
                    num[i]=temp;
                    start++;
                }
                }

                int temp = num[start];
                num[start] = pivot;
                num[end] = temp;
                return start;

                }
    }
	
	
	
	class merg{
		
	
	    void merge(int num[], int l, int m, int r)
	    {
	        int i, j, k;
	        int n1 = m - l + 1;
	        int n2 =  r - m;
	        int[] L = new int[n1];  
	        int[] R = new int[n2];  
	        //int L[n1], R[n2];
	
	        for (i = 0; i < n1; i++)
	            L[i] = num[l + i];
	        for (j = 0; j < n2; j++)
	            R[j] = num[m + 1+ j];
	
	        i = 0; // Initial index of first subarray
	        j = 0; // Initial index of second subarray
	        k = l; // Initial index of merged subarray
	        while (i < n1 && j < n2)
	        {
	            if (L[i] <= R[j])
	            {
	                num[k] = L[i];
	                i++;
	            }
	            else
	            {
	                num[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	
	        while (i < n1)
	        {
	            num[k] = L[i];
	            i++;
	            k++;
	        }
	
	        while (j < n2)
	        {
	            num[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	
	    void mergeSort(int num[], int l, int r)
	    {
	        if (l < r)
	        {
	                int m = l+(r-l)/2;
	
	            mergeSort(num, l, m);
	            mergeSort(num, m+1, r);
	            merge(num, l, m, r);
	        }
	    }
		
	}
	
	
	class heaps{
		void heapify(int num[], int size, int i)
	    {
	        int largest = i;
	        int left = 2*i + 1;
	        int right = 2*i + 2;
	
	        if (left < size && num[left] >num[largest])
	            largest = left;
	
	        if (right < size && num[right] > num[largest])
	            largest = right;
	
	        if (largest != i)
	        {
	        	int temp;
	            temp = num[i];
	            num[i]= num[largest];
	            num[largest] = temp;
	            heapify(num, size, largest);
	        }
	    }
	 
		
		void heapSort(int num[], int size)
		    {
		        int i;
		        for (i = size / 2 - 1; i >= 0; i--)
		            heapify(num, size, i);
		        for (i=size-1; i>=0; i--)
		        {
		        	int temp;
		            temp = num[0];
		            num[0]= num[i];
		            num[i] = temp;
		            heapify(num, i, 0);
		        }
		     }
		       
	}
	
	
	public class Sortings {
	
		private JFrame frame;
		private JTextField textField;
		int key;
		String tname = new String();
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) throws Exception{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Sortings window = new Sortings();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
		/**
		 * Create the application.
		 */
		public Sortings() {
			initialize();
		}
		public int vis(int k,String str){
			key=k;
			tname="Hello";
			tname="pop";
			tname=str;
			frame.setVisible(true);
			return 0;
		}
		
		/**
		 * Initialize the contents of the frame.
		 */
	 
	   
	        private void initialize() {
			
	        frame = new JFrame();
			frame.setBounds(100, 100, 1000, 500);
	        //frame.setBounds(1000, 1000, 1000, 1000);
	        frame.getContentPane().setBackground(Color.PINK);
	        //frame.pack();
	        frame.setVisible(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
	
			
			JTextArea textArea_1 = new JTextArea();
			textArea_1.setFont(new Font("Arial", Font.BOLD, 26));
			textArea_1.setBackground(Color.DARK_GRAY);
			textArea_1.setForeground(Color.WHITE);
			
			textArea_1.setBounds(250, 0, 500, 41);
		//	textArea_1.setBounds(408, 0, 1216, 164);
			
			frame.getContentPane().add(textArea_1);
			
			
			textField = new JTextField();
			textField.setBounds(250, 102, 600, 40);
			//textField.setBounds(408, 408, 1216, 88);
			Font font1 = new Font("Arial", Font.BOLD, 24);
		//	JTextField textfield = new JTextField ();
				System.out.println(textField.getText());
	
			textField.setFont(font1);
			frame.getContentPane().add(textField);
			
			textField.setColumns(10);
			
			JLabel lblEnterInput = new JLabel("ENTER INPUT");
			lblEnterInput.setBounds(60, 105, 180, 20);
			//lblEnterInput.setBounds(120, 420, 340, 64);
		 	lblEnterInput.setFont(new Font("Arial", Font.BOLD, 24));
			frame.getContentPane().add(lblEnterInput);
			
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setBounds(250, 250, 600, 65);
			
			//textArea.setBounds(408, 700, 1216, 164);
			frame.getContentPane().add(textArea);
			
			JButton btnSubmit = new JButton("SUBMIT");
			 btnSubmit.setFont(new Font("Arial", Font.BOLD, 24));
	
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					
					String fin = new String();
					String str=new String();
					str = textField.getText();
					
					String [] tok = str.split(" ");
					int [] num = new int[tok.length];
					
					for(int i=0;i<tok.length;i++){
						num[i]=Integer.parseInt(tok[i]);
					}
					if(key==1)
					{
						int j;
				        boolean flag = true;   // set flag to true to begin first pass
				        int temp;   //holding variable
	
				        while ( flag )
				        {
				            flag= false;    //set flag to false awaiting a possible swap
				            for( j=0;  j < num.length -1;  j++ )
				            {
				                if ( num[ j ] > num[j+1] )   // change to > for ascending sort
				                {
				                    temp = num[ j ];                //swap elements
				                    num[ j ] = num[ j+1 ];
				                    num[ j+1 ] = temp;
				                    flag = true;              //shows a swap occurred
				                }
				            }
				        }
				        fin = "Bubble Sort =";
					}
					if(key==2){
				        int n = num.length;
	
				        // One by one move boundary of unsorted subarray
				        for (int i = 0; i < n-1; i++)
				        {
				            // Find the minimum element in unsorted array
				            int min_idx = i;
				            for (int j = i+1; j < n; j++)
				                if (num[j] < num[min_idx])
				                    min_idx = j;
	
				            // Swap the found minimum element with the first
				            // element
				            int temp = num[min_idx];
				            num[min_idx] = num[i];
				            num[i] = temp;
				        }
				        tname="SELECTION SORT";
				        fin = "Selection Sort =";
					}
					if(key==3){
					
						
						quiks obj2 =new quiks();
						int size=num.length;
						obj2.quickSort(num,0,size-1);
						fin="Quick Sort =";
						tname="QUICK SORT";
					}
					
					if(key==4){
						int i, ke, j;
				        for (i = 1; i < tok.length; i++)
				        {
				            ke = num[i];
				            j = i - 1;
	
				        /* Move elements of arr[0..i-1], that are
				        greater than key, to one position ahead
				        of their current position */
				            while (j >= 0 && num[j] > ke)
				            {
				                num[j + 1] = num[j];
				                j = j - 1;
				            }
				            num[j + 1] = ke;
				        }
				        tname="INSERTION SORT";
				        fin = "Insertion Sort =";
					}
					if(key==5){
						merg obj3=new merg();
						int size =num.length-1;
						obj3.mergeSort(num, 0, size);
						fin ="Merge Sort =";
						tname="MERGE SORT";
					}
					
					if(key==6){
						heaps obj4=new heaps();
						int size;
						size=tok.length;
						obj4.heapSort(num,size);
						fin ="Heap Sort =";
						tname="HEAP SORT";
					}
					
					String str1[] =new String[tok.length];
					for(int i=0;i<tok.length;i++){
						str1[i]=Integer.toString(num[i]);
						fin=fin+" "+str1[i];
					}
					textArea.setText(fin);
					textArea_1.setText(tname);
					Font font = new Font("Arial", Font.BOLD, 24);
			        textArea.setFont(font);
				}
			});
			btnSubmit.setBounds(450, 170, 150, 30);
			//btnSubmit.setBounds(840, 548, 388, 100);
			
			frame.getContentPane().add(btnSubmit);
			
			JLabel lblIntegerMustBe = new JLabel("Integer must be space separated in your input");
			lblIntegerMustBe.setFont(new Font("Arial Black", Font.BOLD, 24));
			lblIntegerMustBe.setBounds(220, 48, 700, 41);
			//lblIntegerMustBe.setBounds(600, 192, 1632, 164);
			frame.getContentPane().add(lblIntegerMustBe);
			
			JLabel lblYourOutput = new JLabel("YOUR OUTPUT");
			lblYourOutput.setFont(new Font("Arial", Font.BOLD, 24));
			lblYourOutput.setBounds(60, 260, 180, 20);
			//lblYourOutput.setBounds(120, 712, 448, 64);
			frame.getContentPane().add(lblYourOutput);
			JButton opennotes = new JButton("NOTES!");
			opennotes.setFont(new Font("Arial", Font.BOLD, 24));
	
			opennotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
				if(key==1)
				{
					try{
				 	Desktop.getDesktop().open(new java.io.File("File/bubble.pdf"));
				 	}catch(Exception ew){
						ew.printStackTrace();
					}
				}

				if(key==2){
					
						try{
						 	Desktop.getDesktop().open(new java.io.File("File/selection.pdf"));
							}catch(Exception ew){
								ew.printStackTrace();
							}
				}
				
				if(key==3){
				
					try{
					 	Desktop.getDesktop().open(new java.io.File("File/quick.pdf"));
						}catch(Exception ew){
							ew.printStackTrace();
						}
				}
				
				if(key==4){
					
					try{
					 	Desktop.getDesktop().open(new java.io.File("File/insertion.pdf"));
						}catch(Exception ew){
							ew.printStackTrace();
						}
				}
				if(key==5){
					
					try{
					 	Desktop.getDesktop().open(new java.io.File("File/merge.pdf"));
						}catch(Exception ew){
							ew.printStackTrace();
						}		
				}
				
				if(key==6){
					try{
			 		 	Desktop.getDesktop().open(new java.io.File("File/heap.pdf"));
						}catch(Exception ew){
							ew.printStackTrace();
		 				}	
				}
				
				}});
			
		//	btnOpenCode.setBounds(372, 244, 97, 25);
			opennotes.setBounds(200, 800, 388, 100);
			frame.getContentPane().add(opennotes);
			//opennotes.setBounds(280, 876, 388, 100);
				
			JButton exit = new JButton("EXIT");
		 	exit.setFont(new Font("Arial", Font.BOLD, 24));
	
			exit.addActionListener(new ActionListener() {
		 		public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					frame.dispose();

		 		}
	 		});
			exit.setBounds(320, 344, 97, 35);
			//exit.setBounds(840, 876, 388, 100);
			frame.getContentPane().add(exit);
			
			
			
			JButton btnOpenCode = new JButton("ALGORITHM + GRAPH!");
			btnOpenCode.setFont(new Font("Arial", Font.BOLD, 24));
	
			btnOpenCode.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
				if(key==1)
				{
					try{
				 	Desktop.getDesktop().open(new java.io.File("File/bubblealgo.pdf"));
				 	}catch(Exception ew){
						ew.printStackTrace();
					}
				}
				if(key==2){
					
						try{
						 	Desktop.getDesktop().open(new java.io.File("File/selectionalgo.pdf"));
							}catch(Exception ew){
								ew.printStackTrace();
							}
				}
				
				if(key==3){
				
					try{
					 	Desktop.getDesktop().open(new java.io.File("File/quickalgo.pdf"));
						}catch(Exception ew){
							ew.printStackTrace();
						}
				}
				
				if(key==4){
					
					try{
					 	Desktop.getDesktop().open(new java.io.File("File/insertionalgo.pdf"));
						}catch(Exception ew){
							ew.printStackTrace();
						}
				}
				if(key==5){
					
					try{
					 	Desktop.getDesktop().open(new java.io.File("File/mergesalgo.pdf"));
						}catch(Exception ew){
							ew.printStackTrace();
						}		
				}
				
				if(key==6){
					try{
			 		 	Desktop.getDesktop().open(new java.io.File("File/heapalgo.pdf"));
						}catch(Exception ew){
							ew.printStackTrace();
		 				}	
				}
				
				}});
			
			btnOpenCode.setBounds(482, 344, 300, 35);
			 //btnOpenCode.setBounds(1488, 876, 388, 100);
			frame.getContentPane().add(btnOpenCode);
			
			 	
			
				
	}
	}
	
