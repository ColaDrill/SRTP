package summary.algo;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAlgo {
	int startTime;
	int endTime;
	List<EventList> timeAxis;
	List<ResultList> result = new ArrayList<ResultList>();
	int[][] S;	//论文里的SS
	int m, n;
	public int status;
	public void getTimeAxis(List<EventList> ta){
		//获取算法的输入
		this.timeAxis = ta;
		System.out.println("获取时间轴成功");
		this.printTimsAxis();
	} 
	public void getS(int m, int n, int[][] S){
		this.m = m; this.n = n;
		this.S = S;
		System.out.println("获取输入矩阵成功");
	}
	public void convertS(){
		//TODO: 根据this.timeAxxis计算出S矩阵， 实现算法的时候假设S已经有了
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
	
	public abstract void calc();  	//利用矩阵S执行算法， 获取到result, 算法实现部分
}
