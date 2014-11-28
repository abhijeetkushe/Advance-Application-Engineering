package model
{

	public class ModelLocator
	{
		public static var inst:ModelLocator;		
		
		[Bindable] public var portraitMode:Boolean = true;
		
		public const GOAL_NUM_RESPONSES:int = 30;
		
		
		public function ModelLocator()
		{			
		}
		
		public static function getInstance():ModelLocator
		{
			if ( !inst )
			{
				inst = new ModelLocator();
			}
			return inst;
		}
	}
}