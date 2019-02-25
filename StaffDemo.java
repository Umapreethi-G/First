package com.infinite.filetask.demo;


	import java.io.BufferedReader;
import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
	import java.util.TreeSet;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class StaffDemo {
		
        private long start=0;

		private String staffId;
		private String name;
		private String dept;
		private String designation;
		private Integer salary;
		private Integer level;
		final String FNAME ="outputFile.txt";
		String fileName = "index.txt";
		TreeSet storeValues = new TreeSet();

		HashMap<String,String> staffMap = new HashMap<>();
		 List<String> _list = new ArrayList<String>();
		public StaffDemo(String staffId, String name, String dept, String designation, Integer salary, Integer level) {
			this.staffId = staffId;
			this.name = name;
			this.dept = dept;
			this.designation = designation;
			this.salary = salary;
			this.level = level;
		}

		public StaffDemo() {
		}

		public String getStaffId() {
			return staffId;
		}

		public void setStaffId(String staffId) {
			this.staffId = staffId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public Integer getSalary() {
			return salary;
		}

		public void setSalary(Integer salary) {
			this.salary = salary;
		}

		public Integer getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}

		public String toString() {
			return "StaffId = " + staffId +" , Name = " + name +" , Dept = " + dept +" , Designation = " + designation
					+" , Salary = " + salary +" , Level = " + level;
		}

		private ArrayList<StaffDemo> staffList = new ArrayList<>();

		public boolean addStaff(StaffDemo staffObj) {
			boolean res = false;
			try {
				staffList.add(staffObj);
				fileCheck(staffObj);
				res = true;
			} catch (Exception e) {
				System.out.println(e);
				return res;
			}
			return res;
		}

		public StaffDemo getStaffById(String id) {
			for (StaffDemo staff : staffList) {
				if (id.equals(staff.getStaffId())) {
					return staff;
				}
			}
			return null;

		}

		public boolean updateStaff(String id, StaffDemo staff) {
			StaffDemo staff2 = getStaffById(id);
			boolean res = false;
			try {
				int index = staffList.indexOf(staff2);
				staffList.set(index, staff);
				delVal();
				res = true;
			} catch (Exception e) {
				System.out.println(e);
				return res;
			}
			return res;
		}

		public boolean deleteStaffById(String id) {
			boolean res1 = false;
			StaffDemo staff = getStaffById(id);
			try {
				staffList.remove(id);
				delVal();
				res1 = true;
			} catch (Exception e) {
				System.out.println(e);
				return res1;
			}
			return res1;

		}

		/*public void fileCheck(StaffDemo obj) {
			FileWriter fileWriter = null;

			BufferedWriter bufferedWriter = null;

			PrintWriter printWriter = null;

			try {
				fileWriter = new FileWriter(FNAME, true);

				bufferedWriter = new BufferedWriter(fileWriter);

				printWriter = new PrintWriter(bufferedWriter);

				printWriter.println(obj);

				System.out.println("Done");
				printWriter.close();
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}*/
		public void fileCheck(StaffDemo obj) {
	        FileWriter fileWriter ,fileWriter2= null;
	        
	        BufferedWriter bufferedWriter ,bufferedWriter2= null;
	        
	        BufferedReader reader=null;
	        PrintWriter printWriter ,printWriter2= null;
	        
	        try
	        {
	            
	        	fileWriter = new FileWriter(FNAME, true);
	             
	            
	            bufferedWriter = new BufferedWriter(fileWriter);
	            
	            
	            printWriter = new PrintWriter(bufferedWriter);
	            
	            RandomAccessFile file = new RandomAccessFile(FNAME,"r");

	            
	            printWriter.println(obj);
	            
	            start = file.length();

	            
	            System.out.println("Done");
	            
	            

	            BufferedReader br = new BufferedReader(new FileReader(fileName));
	           
	            		//System.out.println("hi "+_list);
	                for (String line; (line = br.readLine()) != null;) {
	                	
	                    _list.add(line);
	                }
	                  // staffMap.put(obj.staffId,start);
		                   _list.add(obj.staffId+" "+start);
                    
	            	//System.out.println("-----"+_list+"----");
	            java.util.Collections.sort(_list);
	            //System.out.println("Size of List "+_list.size());
	            
	           
	            
	           // _list.sort();
	            
	           // System.out.println(_list+"*******");
	            	fileWriter2 = new FileWriter(fileName,false);
	            	bufferedWriter2=new BufferedWriter(fileWriter2);
	            	printWriter2 = new PrintWriter(bufferedWriter2);
	            	
	            	for (String str : _list) {
	                    printWriter2.println(str);
	                    
	                }
	            	
	            	// int index = java.util.Collections.binarySearch(_list,"109");
	            	 //System.out.println("Search list "+index);
	            	//lines=null;
	            	_list.clear();
	            
        	   /*fileWriter2 = new FileWriter("index.txt", true);
	             
	            
	            bufferedWriter2 = new BufferedWriter(fileWriter2);
	            
	            
	            printWriter2 = new PrintWriter(bufferedWriter2);
	            
	            
	            
	            printWriter2.println(obj.staffId+"  "+start);*/
 
	            //start+=obj.toString().length()+1;
	           // file.seek(345);
	            //System.out.println("******"+file.readLine());
	            printWriter2.close();
                bufferedWriter2.close();
                fileWriter2.close();
                
	            printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
	        } 
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	       
	    }    
	    	

		public void delVal() {

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(FNAME))) {
				for (StaffDemo line : staffList) {
					bw.write(line + "\n");
				}

				bw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void showvalues() {

			File file = new File(FNAME);
			Scanner sc;
			try {
				sc = new Scanner(file);
				while (sc.hasNextLine())
					System.out.println(sc.nextLine());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void storevalues() {

			File files = new File(FNAME);
			Scanner s1;
			try {
				s1 = new Scanner(files);
				while (s1.hasNextLine())
					storeValues.add(s1.nextLine());
				// System.out.println(storeValues);

			} catch (FileNotFoundException e) {
				System.out.println(e);
			}

		}

		public static boolean validateLetters(String txt) {

			String regx = "^[\\p{L} .'-]+$";
			Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(txt);
			return matcher.find();

		}
       
		public void Findstr(String id) { // This function searches the text for the string

		    /*File file = new File("index.txt");
		     Scanner kb = new Scanner(System.in);
		    System.out.println(" enter the content you looking for");
		    String name = kb.next();
		    Scanner scanner;
		    try {
		        scanner = new Scanner(file).useDelimiter( ",");

		        while (scanner.hasNext()) {
		            final String lineFromFile = scanner.nextLine();
		            if (lineFromFile.contains(name)) {
		                // a match!
		                System.out.println("I found " + name);
		                break;
		            }
		            
		        }
		    } catch (IOException e) {
		        System.out.println(" cannot write to file " + file.toString());
		    }*/
	       // List<String> stafflist = new ArrayList<String>();
	        //String pos = null;
	        
		 //BufferedReader reader=null;
		 try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
            RandomAccessFile file = new RandomAccessFile(FNAME,"r");

			 /****** BEFORE ALTER for (String line; (line = br.readLine()) != null;) {
                	
                    stafflist.add(line);
                    //System.out.println(Integer.parseInt(line));
                }
			 System.out.println("List  "+stafflist);
			 java.util.Collections.sort(stafflist);
			 System.out.println("Sorted List "+stafflist);
			 System.out.println("(((((("+stafflist.contains(id));
			int index = java.util.Collections.binarySearch(stafflist,id);
			
			System.out.println("Found at index: "+index);
			String value = stafflist.get(index);
			
			System.out.println("Stafflist size : "+stafflist.size());
			
			if(index<=stafflist.size()) {
			System.out.println("value: "+value);
			String[] string = value.split(" ");
			for (String string2 : string) {
				pos = string2;
			}
			long seek = Long.parseLong(pos);
			file.seek(seek);
			System.out.println("**&&&&&"+file.readLine());
			}******/
            String lines[] =null;
            for (String line; (line = br.readLine()) != null;) {
            	lines = line.split(" ");
            	staffMap.put(lines[0], lines[1]);
            }
            //staffMap.put(obj.staffId,String.valueOf(start));
          //  System.out.println("++FINAL++  "+staffMap);  
           // System.out.println("Size of HashMap "+staffMap.size());
            
            String key = staffMap.get(id);
           // System.out.println("Key value : "+key);
            
            if(key!= null) {
            long position = Long.parseLong(key);
            file.seek(position);
            System.out.println("******Details of id :"+id+" ******");
            System.out.println(file.readLine());
            }
            else {
            	
            	System.out.println("Oops!!!!   Staff id not found");
            }
			br.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			    
	 }
	 

		@SuppressWarnings("unused")
		public static void main(String[] args) throws Exception {
			boolean check = true;
			StaffDemo staffDemo = new StaffDemo();

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			while (check) {
				System.out.println("1.Add Staff \n2.Delete Staff \n3.Display \n4.update\n5.Display from file \n6.Search id \n7.Exit ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter StaffId: ");
					String staffId = sc.nextLine();
					if (!staffId.equals("")) {
						System.out.println("Enter the staffName: ");
						String staffName = sc.nextLine();
						if (staffDemo.validateLetters(staffName) && (!staffName.equals(""))) {
							System.out.println("Enter Department: ");
							String dept = sc.nextLine();
							if (!dept.equals("")) {
								System.out.println("Enter Designation: ");
								String designation = sc.nextLine();
								if (!designation.equals("")) {
									System.out.println("Enter Salary: ");
									Integer salary = sc.nextInt();
									if (salary != null) {
										System.out.println("Enter Level: ");
										Integer level = sc.nextInt();
										if (level != null) {
											StaffDemo staff = new StaffDemo(staffId, staffName, dept, designation, salary,
													level);
											if (staffDemo.addStaff(staff))
												System.out.println("Success");

										} else {
											throw new Exception("Level should not be zero");
										}
									} else {
										throw new Exception("Salary should not be NULL");
									}
								} else {
									throw new Exception("Designation should not be Zero");
								}
							} else {
								throw new Exception("Department should not be NULL");
							}

						} else {
							throw new Exception("Invalid Name");
						}
					} else {
						throw new Exception("Id should not be NULL");

					}

					break;
				case 2:
					System.out.println("Enter the id to be deleted");
					String delid = sc.nextLine();
					if (staffDemo.deleteStaffById(delid))
						System.out.println("Deletion Success");
					break;
				case 3:
					System.out.println("Enter id to be display");

					String gid = sc.nextLine();
					StaffDemo staff2 = staffDemo.getStaffById(gid);
					System.out.println(staff2);

					break;

				case 4:
					System.out.println("Enter the id to update");
					String uId = sc.nextLine();
					System.out.println("Enter StaffName : ");
					String uname = sc.nextLine();
					System.out.println("Enter Dept : ");
					String udept = sc.nextLine();
					System.out.println("Enter Salary : ");
					Integer usalary = sc.nextInt();
					System.out.println("Enter designation: ");
					String udesignation = sc.next();
					System.out.println("Enter level: ");
					Integer ulevel = sc.nextInt();
					StaffDemo staff = new StaffDemo(uId, uname, udept, udesignation, usalary, ulevel);
					System.out.println(staffDemo.updateStaff(uId, staff));
					break;

				case 5:
					staffDemo.showvalues();
					// staffDemo.storevalues();
					break;

				case 6:
					System.out.println("Enter id to search: ");
					String sid = sc.nextLine();
					staffDemo.Findstr(sid);
					break;
				
				case 7:
				
					System.exit(0);

				}
				System.out.println("Do you want to continue : Press yes to continue ");
				String cont = sc.next();
				check = cont.equalsIgnoreCase("yes");
			}

		}

	}

