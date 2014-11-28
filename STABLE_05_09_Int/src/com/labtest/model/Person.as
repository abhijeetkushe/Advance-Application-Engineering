// ActionScript file
package com.labtest.model
{	


import mx.binding.utils.*;
import mx.controls.*;
[Bindable]
public class Person extends Object
{
	[Bindable]
	public var name:String="";
	public var address:String="";
	public var city:String="";
	public var phone:String="";
	public var statezip:String="";
	public var country:String="";
	
	public var myWatcher:ChangeWatcher;
	public  function getName():String {return name;}
	
	public function getAddress():String{return address;}
	
	public function getCity():String{return city;}
	
	public function getPhone():String{return phone;}
	
	public function getStatezip():String{return statezip;}
	
	
	public function setName(nameparam:String):void{
		name=nameparam;}
	public function getCountry():String{return country;}
	
	public function setAddress(addressParam:String):void{
	address=addressParam;}
	
	public function setCity(cityParam:String):void{
		city=cityParam;}
	
	public function setPhone(phoneParam:String):void{
		this.phone=phoneParam;}
	
	public function setStatezip(statezipParam:String):void{
		this.statezip=statezipParam;}
	public function toString():String{
		return name+" "+address;
	}
	
	// Define binding watcher. 
	public function initWatcher():void {
		// Define a watcher for the text binding.
		ChangeWatcher.watch(name, "text", watcherListener);
	}
	
	// Event listener when binding occurs. 
	public function watcherListener(event:Event):void {
		Alert.show("Test");
		
		// Use myWatcher.unwatch() to remove the watcher.
	}
}



};