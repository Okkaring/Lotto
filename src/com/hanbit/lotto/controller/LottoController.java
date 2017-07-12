package com.hanbit.lotto.controller;

import javax.swing.JOptionPane;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServiceImpl;


public class LottoController {
	public static void main(String[] args) {
	LottoService service = new LottoServiceImpl(); 
	LottoBean bean=new LottoBean();
	
		while(true){
			switch(JOptionPane.showInputDialog("0. exit 1. buy Lotto")){
				case "0" : 
					JOptionPane.showMessageDialog(null, "Stop");
					return;
				case "1" : 
					bean = new LottoBean();
					bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("얼마치를 구입하십니까?")));
					service.setLottos(bean);
					
					int[][] lottos = service.getLottos();
					
					for(int i=0;i<lottos.length;i++){
						for(int j=0;j<lottos[i].length;j++){
							System.out.print(lottos[i][j]+"\t");
						}
					System.out.println();
					}
					//파일로 결과를 줄겁니다.					
					break;
			}
		}
	}
}
