package com.labtest.model
{
	import flash.utils.Dictionary;
	
	import mx.controls.Alert;

	public class MonroeFactory
	{
		public var monroeMap:Dictionary=new Dictionary();
		public function MonroeFactory()
		{
			var curve06:MonroeCurve=new MonroeCurve();
			var curve12:MonroeCurve=new MonroeCurve();
			var curve18:MonroeCurve=new MonroeCurve();
			var curve24:MonroeCurve=new MonroeCurve();
			var curve30:MonroeCurve=new MonroeCurve();
			var curve36:MonroeCurve=new MonroeCurve();
			var curve42:MonroeCurve=new MonroeCurve();
			var curve48:MonroeCurve=new MonroeCurve();
			var curve54:MonroeCurve=new MonroeCurve();
			var curve60:MonroeCurve=new MonroeCurve();
			
			var lowerBoundFunct:MonroeFunction=new MonroeFunction();
			var upperBoundFunct:MonroeFunction=new MonroeFunction();
			lowerBoundFunct.slope=2;lowerBoundFunct.constant=6;
			upperBoundFunct.slope=3.5;upperBoundFunct.constant=20;
			curve06.lowerBoundFunct=lowerBoundFunct;
			curve06.upperBoundFunct=upperBoundFunct;
			monroeMap[6]=curve06;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=1.33;lowerBoundFunct.constant=18;
			upperBoundFunct.slope=1.5;upperBoundFunct.constant=40;
			curve12.lowerBoundFunct=lowerBoundFunct;
			curve12.upperBoundFunct=upperBoundFunct;
			monroeMap[12]=curve12;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=.1;lowerBoundFunct.constant=26;
			upperBoundFunct.slope=-0.5;upperBoundFunct.constant=48.5;
			curve18.lowerBoundFunct=lowerBoundFunct;
			curve18.upperBoundFunct=upperBoundFunct;
			monroeMap[18]=curve18;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=-1;lowerBoundFunct.constant=26;
			upperBoundFunct.slope=-0.67;upperBoundFunct.constant=45.5;
			curve24.lowerBoundFunct=lowerBoundFunct;
			curve24.upperBoundFunct=upperBoundFunct;
			monroeMap[24]=curve24;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=-0.67;lowerBoundFunct.constant=22;
			upperBoundFunct.slope=-0.35;upperBoundFunct.constant=40.5;
			curve30.lowerBoundFunct=lowerBoundFunct;
			curve30.upperBoundFunct=upperBoundFunct;
			monroeMap[30]=curve30;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=-.25;lowerBoundFunct.constant=19.5;
			upperBoundFunct.slope=-0.37;upperBoundFunct.constant=38.5;
			curve36.lowerBoundFunct=lowerBoundFunct;
			curve36.upperBoundFunct=upperBoundFunct;
			monroeMap[36]=curve36;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=-.45;lowerBoundFunct.constant=18;
			upperBoundFunct.slope=-.35;upperBoundFunct.constant=35.5;
			curve42.lowerBoundFunct=lowerBoundFunct;
			curve42.upperBoundFunct=upperBoundFunct;
			monroeMap[42]=curve42;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=-.42;lowerBoundFunct.constant=15;
			upperBoundFunct.slope=-.36;upperBoundFunct.constant=31.75;
			curve48.lowerBoundFunct=lowerBoundFunct;
			curve48.upperBoundFunct=upperBoundFunct;
			monroeMap[48]=curve48;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=-.5;lowerBoundFunct.constant=10;
			upperBoundFunct.slope=-.4;upperBoundFunct.constant=29.3;
			curve54.lowerBoundFunct=lowerBoundFunct;
			curve54.upperBoundFunct=upperBoundFunct;
			monroeMap[54]=curve54;
			
			lowerBoundFunct=new MonroeFunction();
			upperBoundFunct=new MonroeFunction();
			lowerBoundFunct.slope=-.42;lowerBoundFunct.constant=8;
			upperBoundFunct.slope=-.33;upperBoundFunct.constant=25.3;
			curve60.lowerBoundFunct=lowerBoundFunct;
			curve60.upperBoundFunct=upperBoundFunct;
			monroeMap[60]=curve60;		
		}
		
		public function getMonroeCurve(upperBound:int):MonroeCurve{
			
			return monroeMap[upperBound];
		}
			
	}
}