package summary.algo;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAlgo {
	int startTime;
	int endTime;
	List<EventList> timeAxis;
	List<ResultList> result = new ArrayList<ResultList>();
	int[][] S;	//�������SS
	int m, n;
	public int status;
	public void getTimeAxis(List<EventList> ta){
		//��ȡ�㷨������
		this.timeAxis = ta;
		System.out.println("��ȡʱ����ɹ�");
		this.printTimsAxis();
	} 
	public void getS(int m, int n, int[][] S){
		this.m = m; this.n = n;
		this.S = S;
		System.out.println("��ȡ�������ɹ�");
	}
	public void convertS(){
		//TODO: ����this.timeAxxis�����S���� ʵ���㷨��ʱ�����S�Ѿ�����
	}
	public void printTimsAxis(){
		for(EventList et : this.timeAxis){
			et.print();
		}
	}
	public void printResult(){
		for(ResultList rt : this.result){
			rt.print();
		}
	}
	
	public double getTL(){
		double res = 0;
		int k = this.result.size();
		res += k*Math.log(n);
		for(int i=0; i<k; i++){
			res += result.get(i).getLL();
		}
		return res;
	}
	
	public abstract void calc();  	//���þ���Sִ���㷨�� ��ȡ��result, �㷨ʵ�ֲ���
}
