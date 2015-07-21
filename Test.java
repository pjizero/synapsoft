import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
	public static void main( String args[] ) {
		ArrayList<String> intList = new ArrayList<String>();		//자연수를 입력받기 위한 스트링리스트	

		StringBuffer str1 = new StringBuffer();				//자연수 조합을 담기위한 스트링버퍼
		StringBuffer str2 = new StringBuffer();
		
		int parseA, minTotal, i = 0, j = 0, non = 0, idx;
			//parseA : 입력받은 string 숫자를 int형으로 바꿔서 담기위한 변수
			//minTotal : 합이 최소가 되는 값의 변수
			//i, j, non, idx : 반복문을 돌리기위한 변수
		int nonzeroIDX = 0;
			//'0'의 개수를 카운트하기위한 변수
		
		String num;				//숫자를 입력받기 위한 변수
		String temp1, temp2;			//String형 자연수조합을 담은 str1, str2를 int형으로 변환해 담을 변수
		
		start:
		while(true){
			Scanner scan = new Scanner(System.in);    
			System.out.print("2개 이상 숫자 입력(종료:/) : ");
			num = scan.next();
			
			/*숫자입력 조건과정 */
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
		
		/*입력받은 수의 개수가 홀수일 경우*/
		if( intList.size() % 2 != 0 ) {
			idx = 0;
			if( !intList.get(0).equals("0") ) {						//정렬된 리스트에 '0'이 없을 경우
				for( i = 0; i < intList.size(); i += 2 ) { 				//인덱스를 2씩 증가시켜 자연수 조합
					str1.insert(idx, intList.get(i).toString());
					if( i + 1 < intList.size() ) {
						str2.insert(idx, intList.get(i + 1).toString());
					}
					idx++;
				}
				System.out.println("(" + str1 + "," + str2 + ")");
				temp1 = str1.toString();
				temp2 = str2.toString();
				minTotal = Integer.parseInt(temp1) + Integer.parseInt(temp2);		//String형인 자연수 조합을 int형으로 변환
				System.out.println(minTotal);
			} else if( intList.get(0).equals("0") ) {					//정렬된 리스트에 '0'이 있을 경우
				for( i = 0; i < intList.size(); i++ ) {					//정렬된 리스트의 0의 개수를 카운트
					if( !intList.get(i).equals("0") ) break;
				} nonzeroIDX = i;
				if( nonzeroIDX + 1 == intList.size() ) {				//nonzeroIDX에 1을 더해서 리스트의 크기와 같으면 
					System.out.println("-1");					//두개의 자연수 조합이 불가능한것으로 보아 '-1' 출력
				}
				/*'0'의 개수가 짝수개 일 때*/
				else if( i % 2 == 0 ) {					
					str1.insert(idx, intList.get(nonzeroIDX).toString());		
						//'0'이 자연수조합에 첫번째로 올 수 없으니 첫번째로 나온 '0'이 아닌 숫자를 첫번째 자연수 조합의 첫번째 자리로 입력
					idx++;
					str1.insert(idx, intList.get(j).toString());			//맨 처음의 숫자'0'을 두번째 자리에 입력
					for( i = nonzeroIDX + 2; i < intList.size(); i+=2 ) {
						idx++;
						str1.insert(idx, intList.get(i).toString());
						non = nonzeroIDX + 1;					//두번째로 나온 '0'이 아닌 숫자의 위치
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
				}
				/*'0'의 개수가 홀수개 일 때*/
				else if( i % 2 != 0 ) {
					str1.insert(idx, intList.get(nonzeroIDX).toString());
					//'0'이 자연수조합에 첫번째로 올 수 없으니 첫번째로 나온 '0'이 아닌 숫자를 자연수 첫번째 자연수 조합의 첫번째 자리로 입력
					str2.insert(idx, intList.get(nonzeroIDX + 1).toString());
					//두번째로 나온 '0'이 아닌 숫자를 두번째 자연수 조합의 두번째 자리로 입력
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
		} 
		/*입력받은 수의 개수가 짝수일 경우*/
		else if( intList.size() % 2 == 0 ) {	
			idx = 0;
			if( !intList.get(0).equals("0") ) {					//정렬된 리스트에 '0'이 없을 경우						
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
			} else if( intList.get(0).equals("0") ) {				//정렬된 리스트에 '0'이 있을 경우
				for( i = 0; i < intList.size(); i++ ) {
					if( !intList.get(i).equals("0") ) break;
				} nonzeroIDX = i;
				if( nonzeroIDX + 1 == intList.size() ) {
					System.out.println("-1");
				}
				/*'0'의 개수가 짝수개 일 때*/
				else if( i % 2 == 0 ) {
					str1.insert(idx, intList.get(nonzeroIDX).toString());	
					//첫번째로 나온 '0'이 아닌 숫자를 첫번째 자연수 조합의 첫번째자리로 입력
					idx++;
					for( int n = 0; n < nonzeroIDX; n += 2 ) {						//'0'의 개수보다 작게 자연수 조합 두번째 자리부터 '0'을 입력
						str1.insert(idx, intList.get(n).toString());
						idx++;
					}
					for( int m = nonzeroIDX + 2; m < intList.size(); m += 2 ) {		//'0'이 아닌 숫자를 이어서 입력
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
				}
				/*'0'의 개수가 홀수개 일 때*/
				else if( i % 2 != 0 ) {
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
