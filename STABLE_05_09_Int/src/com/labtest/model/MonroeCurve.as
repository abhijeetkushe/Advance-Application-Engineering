package com.labtest.model
{
	import flash.utils.Dictionary;

	public class MonroeCurve
	{
		public var lowerBoundFunct:MonroeFunction;
		public var upperBoundFunct:MonroeFunction
		public var upperCutOff:int=8;
		public var lowerCutOff:int=8;
		
		public function applyFunction(time:int,ancCount:int):int{
			var timeFunctVal:int=compressANCCount(ancCount);
			var upperFunctVal:int=upperBoundFunct.getValue(time);
			var lowerFunctVal:int=lowerBoundFunct.getValue(time);
			if(timeFunctVal>=(lowerFunctVal-lowerCutOff) && timeFunctVal<=(upperFunctVal+upperCutOff)){
			
				return 0;
			}
			else{
				return 1;
			}
				
			
		}
		
		
		public function compressANCCount(ancCount:int):int{
			
			var rangeCount:int=ancCount/1800;
			return rangeCount*6;
		}
		
		
		
		
	}
}