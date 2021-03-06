package com.hanbit.lotto.serviceImpl;


import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServiceImpl implements LottoService{
	 int[][] lottos;
	 int[] lotto; // 돈과 상관없이 생성되는 한 줄 (숫자 6) 로또
	 private int count;
	
	@Override
	public int getCount() {
		// 해당 로또수만큼 출력
		return count;
	}
	@Override
	public void setCount(LottoBean bean) {
		// 몇줄을 출력할 것인지 로또 수 계산(최대값 5줄)
	/*	int x=bean.getMoney()/1000;
		if(x>=5){
			x=5;
		}else{
			x = bean.getMoney()/1000;
		}*/
		
		count = ((bean.getMoney()/1000)>5)?5:bean.getMoney()/1000;
	}
	
	@Override
	public void setLottos(LottoBean bean) {
		// 로또 만들기
		setCount(bean);
		lotto= new int[6];
		lottos = new int[count][6];
		
		int i=0;
		for(count=0;count<lottos.length;count++){
			while(true){
				int num = bean.getNumber();
				if(isDuplication(count, num)){
					continue;
				}
				lottos[count][i]= num; 
				i++;
				//System.out.println("추출된 로또볼: "+bean.getNumber());
				if(i==lottos[count].length){
					sort(lottos[count]);
					i=0;
					break;
				}
				
			}
		}
	}
	
	@Override
	public int[][] getLottos() {
		// 만든로또 가져오기
		return lottos;
	}
	@Override
	public boolean isDuplication(int count, int num) {
		// 중복된 번호인지 체크 (중복이면 TRUE 리턴)
		boolean flag = false;
		for(int i=0;i<lottos[count].length;i++){
			if(lottos[count][i]==num){
				flag=true;
				break;
			}
		}
		return flag;
	}
	@Override
	public void sort(int[] arr) {
		// 오름 차순 정렬 swap정렬
		int temp = 0;
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]>arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}