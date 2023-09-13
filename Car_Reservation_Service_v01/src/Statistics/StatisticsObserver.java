package statistics.Controller;

import payment.controller.PaymentService;
import statistics.Model.Statistics;
import statistics.View.StatisticsView;

public class StatisticsObserver implements Observer
{
	private PaymentService payment; 
	private Statistics statistics = new Statistics(); 
	private StatisticsView statisticsView = new StatisticsView();

public StatisticsObserver (PaymentService payment)
{
		this.payment = payment;	
		this.payment.addObserver(this); 	
}

public void showStatistics() 
	{
		
		statisticsView.printStatistics();
		
	}

	@Override
	public void update() 
	{
		statistics.updateStatistics(); 
	}
	

}
