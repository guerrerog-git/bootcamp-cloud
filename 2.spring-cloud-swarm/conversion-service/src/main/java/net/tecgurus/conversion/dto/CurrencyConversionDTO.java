package net.tecgurus.conversion.dto;

public class CurrencyConversionDTO {

	private double total;
	private int port;
	private double conversionMultiple;
	
	
	public double getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	
}
