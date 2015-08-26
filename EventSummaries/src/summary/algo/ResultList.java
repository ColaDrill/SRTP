package summary.algo;

import java.util.ArrayList;
import java.util.List;

class ResultList{
	int startTime;
	int endTime;
	ArrayList< Double > P;
	ArrayList< List<Integer> > X;
	int m, n;
	int _size;
	
	int size(){
		this._size = this.P.size();
		if(this._size == this.X.size()){
			return this._size;
		}else{
			throw new ArithmeticException("请确保概率P和分组X一一对应");
		}
	}
	
	public static int[][] S;
	
	public ResultList(){
		this.P = new ArrayList<Double>();
		this.X = new ArrayList<List<Integer>>();
	}
	
	public ResultList(double pi, int... args){
		this();
		this.append(pi, args);
	}
	
	public ResultList(int m, int n, int[][] S){
		this();
		this.m = m; this.n = n;
		ResultList.S = S;
	}
	
	public double getLL(){
		return this.getLD() + this.getLM();
	}
	//对于当前分组的 LD = - log ( Pr ( Si | Mi ) )
	// 这里算的是 Pr....
	
	public double getLD(){
		double pr = 1;	//Pr(Si|Mi)
		int I = this.endTime - this.startTime;
		for(int j=0; j<this.size(); j++){
			double pxj;
			int cnt = 0;
			for(int x : X.get(j)){
				for(int k=startTime;k<endTime; k++ ){
					if(S[x][k] == 1){
						cnt++;
					}
				}
			}
			pxj = 1.0 * cnt / (I*X.get(j).size());
			for(int i=0; i<this.X.get(j).size(); i++){
				int ne = 0;
				int e = X.get(j).get(i);
				for(int k = startTime; k<endTime; k++){
					if(S[e][k] == 1){
						ne++;
					}
				}
				pr = pr * Math.pow(pxj, ne) * Math.pow(1-pxj, I-ne);
			}
		}
		return pr;
	}
	
	public double getLM(){
		return (2*this.size()+m)*Math.log(m);
	}
	
	public void append(double pi, int... args){
		//添加一组分组， 第一个参数为概率， 后面的不定长参数为事件标号
		//例如append(0.5, 1, 2); 则表示添加一个分组， 事件包含1和2， 概率为0.5
		this.P.add(pi);
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for(int arg : args){
			tmp.add(arg);
		}
		this.X.add(tmp);
		return;
	}
	
	public void print(){
		System.out.printf("I:[%d, %d] ", this.startTime, this.endTime);
		for(int i=0; i<this.size(); i++){
			System.out.printf("P:%.2f | ", P.get(i));
			for(Integer _x : X.get(i)){
				System.out.printf("%d, ", _x);
			}
		}
		System.out.println();
	}
}