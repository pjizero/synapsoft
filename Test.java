import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
	public static void main( String args[] ) {
		ArrayList<String> intList = new ArrayList<String>();

		StringBuffer str1 = new StringBuffer();
		StringBuffer str2 = new StringBuffer();
		
		int parseA, minTotal, i = 0, j = 0, non = 0, idx;
		int nonzeroIDX = 0;
		
		String num;
		String temp1, temp2;
		
		start:
		while(true){
			Scanner scan = new Scanner(System.in);    
			System.out.print("2개 이상 숫자 입력(종료:/) : ");
			num = scan.next();
			if( num.equals("/") && intList.size() < 2 ) {
				System.out.println("입력개수 부족 처음부터 다시입력");
				continue start;
			} else if( intList.size() < 2 ) {
				parseA = Integer.parseInt(num);
				if( parseA < 0 || parseA > 9 ) {
					System.out.println("숫자범위 초과!!");
					continue start;
				}
			} else if( intList.size() >= 18 || num.equals("/") ) {
				if( intList.size() >= 18) { 
					System.out.println("입력개수 초과!!");
					break;
				} else if( num.equals("/") ) break;
			}
			intList.add(num);		
		}
		
		Collections.sort(intList);
		System.out.println(intList);
		
		if( intList.size() % 2 != 0 ) {
			idx = 0;
			if( !intList.get(0).equals("0") ) {
				for( i = 0; i < intList.size(); i += 2 ) { 
					str1.insert(idx, intList.get(i).toString());
					if( i + 1 < intList.size() ) {
						str2.insert(idx, intList.get(i + 1).toString());
					}
					idx++;
				}
				System.out.println("(" + str1 + "," + str2 + ")");
				temp1 = str1.toString();
				temp2 = str2.toString();
				minTotal = Integer.parseInt(temp1) + Integer.parseInt(temp2);
				System.out.println(minTotal);
			} else if( intList.get(0).equals("0") ) {
				for( i = 0; i < intList.size(); i++ ) {
					if( !intList.get(i).equals("0") ) break;
				} nonzeroIDX = i;
				if( nonzeroIDX + 1 == intList.size() ) {
					System.out.println("-1");
				} else if( i % 2 == 0 ) {
					str1.insert(idx, intList.get(nonzeroIDX).toString());
					idx++;
					str1.insert(idx, intList.get(j).toString());
					for( i = nonzeroIDX + 2; i < intList.size(); i+=2 ) {
						idx++;
						str1.insert(idx, intList.get(i).toString());
						non = nonzeroIDX + 1;
						if( non < intList.size() ) {
							idx = 0;
							str2.insert(idx, intList.get(non).toString());
							idx++;
							str2.insert(idx, intList.get(j).toString());
						}
					}
					System.out.println("(" + str1 + "," + str2 + ")");
					temp1 = str1.toString();
					temp2 = str2.toString();
					minTotal = Integer.parseInt(temp1) + Integer.parseInt(temp2);
					System.out.println(minTotal);
				} else if( i % 2 != 0 ) {
					str1.insert(idx, intList.get(nonzeroIDX).toString());
					str2.insert(idx, intList.get(nonzeroIDX + 1).toString());
					str2.insert(idx + 1, intList.get(j + 1).toString());
					for( int n = 0; n < i; n += 2 ) {
						idx++;
						str1.insert(idx, intList.get(n).toString());
					}
					System.out.println("(" + str1 + "," + str2 + ")");
					temp1 = str1.toString();
					temp2 = str2.toString();
					minTotal = Integer.parseInt(temp1) + Integer.parseInt(temp2);
					System.out.println(minTotal);
				}
			}
		} else if( intList.size() % 2 == 0 ) {
			idx = 0;
			if( !intList.get(0).equals("0") ) {
				for( i = 0; i < intList.size(); i+=2 ) {
					str1.insert(idx, intList.get(i).toString());
					if( i + 1 <= intList.size() ) {
						str2.insert(idx, intList.get(i+1).toString());
					}
					idx++;
				}
				System.out.println("(" + str1 + "," + str2 + ")");
				temp1 = str1.toString();
				temp2 = str2.toString();
				minTotal = Integer.parseInt(temp1) + Integer.parseInt(temp2);
				System.out.println(minTotal);
			} else if( intList.get(0).equals("0") ) {
				for( i = 0; i < intList.size(); i++ ) {
					if( !intList.get(i).equals("0") ) break;
				} nonzeroIDX = i;
				if( nonzeroIDX + 1 == intList.size() ) {
					System.out.println("-1");
				} else if( i % 2 == 0 ) {
					str1.insert(idx, intList.get(nonzeroIDX).toString());
					idx++;
					for( int n = 0; n < nonzeroIDX; n += 2 ) {
						str1.insert(idx, intList.get(n).toString());
						idx++;
					}
					for( int m = nonzeroIDX + 2; m < intList.size(); m += 2 ) {
						str1.insert(idx, intList.get(m).toString());
						idx++;
					} 
					non = nonzeroIDX + 1;
					str2.insert(j, intList.get(non).toString());
					j++;
					for( int n = 1; n < nonzeroIDX; n += 2 ) {
						str2.insert(j, intList.get(n).toString());
						j++;
					}
					for( int m = nonzeroIDX + 2; m < intList.size(); m += 2 ) {
						str2.insert(j, intList.get(m).toString());
						j++;
					}
					System.out.println("(" + str1 + "," + str2 + ")");
					temp1 = str1.toString();
					temp2 = str2.toString();
					minTotal = Integer.parseInt(temp1) + Integer.parseInt(temp2);
					System.out.println(minTotal);
				} else if( i % 2 != 0 ) {
					str1.insert(idx, intList.get(nonzeroIDX).toString());
					for( int n = 0; n < i; n += 2 ) {
						idx++;
						str1.insert(idx, intList.get(n).toString());
					}
					for( int n = nonzeroIDX + 1; n < intList.size(); n +=2 ) {
						idx = 0;
						str2.insert(idx, intList.get(n).toString());
						idx++;
						str2.insert(idx, intList.get(j).toString());
						idx++;
						str2.insert(idx, intList.get(intList.size()-1).toString());
					}
					System.out.println("(" + str1 + "," + str2 + ")");
					temp1 = str1.toString();
					temp2 = str2.toString();
					minTotal = Integer.parseInt(temp1) + Integer.parseInt(temp2);
					System.out.println(minTotal);
				}
			}		
			
		}
				
	}
}
