package javaapp10;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class javaapp10 {
	public static void main(String[] args) {
		DemoProperty dp = new DemoProperty();
		dp.getKProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observer, Number oldValue, Number newValue) {
			 System.out.println("Old value: " +oldValue + ", new value " +newValue);
			}
		});
		dp.setK(0.5);
		dp.setK(-1.5);
		dp.setK(100);
		
		DoubleProperty d = new SimpleDoubleProperty(10);
		DoubleBinding db= new DoubleBinding() {
			
			{
				super.bind(dp.getKProperty(),d);
			}
			@Override
			protected double computeValue() {
				// TODO Auto-generated method stub
				return dp.getK() + d.get();
			}
		};
		System.out.println(db.get());
}

}
class DemoProperty{
	
	private DoubleProperty k=new SimpleDoubleProperty(0);

	public double getK() {
		return k.get();
	}
	public void setK(double K) {
		this.k.set(K);
	}
	public DoubleProperty getKProperty() {
		return k;
		
	}
}
