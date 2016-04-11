package Base.custom;

public class DouArr {


		double[] localdoubles;
		
		public DouArr(double...d){
			localdoubles = d;
		}
		public DouArr(){
			localdoubles = new double[0];
		}
		
		public DouArr(String...d){
			double[] hold = new double[d.length];
			for(int n = 0; n < d.length; n++){
				hold[n] = Double.parseDouble(d[n]);
			}
			this.localdoubles = hold;
		}
		
		public boolean set(int index, double num){
			if(index < localdoubles.length && index >= 0){
				localdoubles[index] = num;
				return true;
			}
			return false;
		}
		
		public void append(double num){
			double[] hold = new double[localdoubles.length+1];
			for(int i = 0; i < localdoubles.length; i++){
				hold[i] = localdoubles[i];
			}
			hold[localdoubles.length] = num;
			localdoubles = hold;
		}
		
		public double[] get(){
			return localdoubles;
		}
		
		public double get(int index){
			if(index < localdoubles.length && index >= 0){
				return localdoubles[index];
			}
			return localdoubles[index];
		}
		
		public boolean matches(int index, double num){
			if(index < localdoubles.length && index >= 0){
				return localdoubles[index] == num;
			}
			return false;
		}
		
		public void insertArray(double...d){
			this.localdoubles = d;
		}
		
		public void insertArray(String...d){
			double[] hold = new double[d.length];
			for(int n = 0; n < d.length; n++){
				hold[n] = Double.parseDouble(d[n]);
			}
			
			this.localdoubles = hold;
		}
		
		public int size(){
			return localdoubles.length;
		}
		
		
		@Override 
		public String toString(){
			
			String s = "[";
			
			for(int i = 0; i < localdoubles.length; i++){
				if(i == 0){
				s+=	localdoubles[i];
				}else{
				s+= ","+localdoubles[i];
				}
			}
			s += "]";
			
			return s;
		}
		
		@Override
		public int hashCode(){
			
			return this.toString().hashCode()+(""+localdoubles.length).hashCode();
		}
		
		@Override
		public boolean equals(Object obj){
			if(obj == null){
				return false;
			}
			if(!(obj instanceof DouArr)){
				return false;
			}
			
			return this.hashCode() == obj.hashCode();
		}
		
	}


