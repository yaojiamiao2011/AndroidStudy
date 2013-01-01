package com.dongbaosoft.Android.comm.ref;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Michael
 * 
 */
public class TestMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> valMap = new HashMap<String, String>();
		valMap.put("userName", "michael");
		valMap.put("age", "27");
		valMap.put("height", "173.5");
		valMap.put("date", "2010-10-24");
		valMap.put("times", "1287932898276");
		valMap.put("flag", "false");
		/**
		 * 
		TestBean testBean = new TestBean();
		System.out.println("通过反射赋值.");
		BeanRefUtil.setFieldValue(testBean, valMap);
		System.out.println("通过反射取值:");
		Map<String, String> fieldValMap = BeanRefUtil
				.getFieldValueMap(testBean);
		for (Entry<String, String> entry : fieldValMap.entrySet()) {
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
		 */
	}
}