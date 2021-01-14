package ceshi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ceshi {
	
	private static final String strn="2_2,1875,0,8490_2,1887,0,8228_2,1887,0,8202_2,1891,0,7916_2,1893,0,7632_2,1931,0,7352_2,1947,0,7203_2,1954,0,7078_2,1956,0,7041_2,1963,0,6903_2,2024,0,4646_2,2112,0,2711_2,2183,0,1768_2,1890,0,1238_2,1884,0,904_2,1884,0,746_2,1891,500,9000_2,1896,500,8228_2,1909,500,8202_2,1920,500,7916_2,1931,500,7632_2,1931,500,7352_2,1943,500,7203_2,1990,500,7078_2,2078,500,7036_2,2137,500,6897_2,1891,500,4646_2,1877,500,2711_2,1877,500,1768_2,1881,500,1238_2,1898,500,904_2,1911,500,742_2,1913,1000,9000_2,1916,1000,8228_2,1917,1000,8202_2,1921,1000,7916_2,1962,1000,7632_2,2040,1000,7352_2,2099,1000,7203_2,1890,1000,7078_2,1867,1000,7020_2,1867,1000,6879_2,1870,1000,4646_2,1875,1000,2711_2,1893,1000,1768_2,1901,1000,1238_2,1901,1000,904_2,1901,1000,728_2,1904,1500,9000_2,1934,1500,8228_2,2000,1500,8202_2,2066,1500,7916_2,1888,1500,7632_2,1860,1500,7352_2,1858,1500,7203_2,1855,1500,7078_2,1855,1500,6992_2,1868,1500,6850_2,1883,1500,4646_2,1882,1500,2711_2,1882,1500,1768_2,1883,1500,1238_2,1884,1500,904_2,1908,1500,705_2,1964,2000,9000_2,2034,2000,8228_2,2034,2000,8202_2,1886,2000,7916_2,1851,2000,7632_2,1850,2000,7352_2,1839,2000,7078_2,1838,2000,6957_2,1843,2000,6953_2,1860,2000,6811_2,1865,2000,6806_2,1868,2000,4646_2,1868,2000,2711_2,1872,2000,1768_2,1880,2000,1238_2,1932,2000,904_2,1997,2000,676_2,2011,2000,673_2,1884,2500,9000_2,1845,2500,8228_2,1843,2500,8202_2,1829,2500,7916_2,1823,2500,7632_2,1826,2500,7352_2,1833,2500,7078_2,1833,2500,6957_2,1836,2500,6899_2,1839,2500,6811_2,1845,2500,6748_2,1864,2500,4646_2,1905,2500,2711_2,1919,2500,1768_2,1882,2500,1238_2,1836,2500,904_2,1836,2500,676_2,1823,2500,632_2,1822,3000,9000_2,1822,3000,8228_2,1822,3000,8202_2,1823,3000,7916_2,1827,3000,7632_2,1839,3000,7352_2,1846,3000,7203_2,1861,3000,7131_2,1880,3000,7078_2,1829,3000,7000_2,1829,3000,4646_2,1822,3000,2711_2,1822,3000,1768_2,1822,3000,1238_2,1826,3000,904_2,1826,3000,830_2,1827,3500,9000_2,1831,3500,8228_2,1833,3500,8202_2,1833,3500,7916_2,1879,3500,7632_2,1828,3500,7454_2,1828,3500,7352_2,1826,3500,7300_2,1821,3500,7184_2,1819,3500,4646_2,1817,3500,2711_2,1815,3500,1768_2,1813,3500,1238_2,1814,3500,1018_2,1875,4000,9000_2,1835,4000,8228_2,1835,4000,8202_2,1833,4000,7916_2,1816,4000,7632_2,1815,4000,7454_2,1814,4000,7425_2,1812,4000,7352_2,1808,4000,7320_2,1796,4000,4646_2,1802,4000,2711_2,1876,4000,1768_2,1834,4000,1238_2,1834,4000,1192_2,1825,4500,9000_2,1802,4500,8228_2,1807,4500,8202_2,1809,4500,7916_2,1807,4500,7709_2,1800,4500,7632_2,1789,4500,7520_2,1789,4500,7424_2,1874,4500,4646_2,1830,4500,2711_2,1829,4500,1768_2,1811,4500,1351_2,1800,5000,9000_2,1800,5000,8228_2,1799,5000,8202_2,1799,5000,7916_2,1791,5000,7709_2,1779,5000,7632_2,1778,5000,7593_2,1869,5000,7505_2,1830,5000,4646_2,1829,5000,2711_2,1811,5000,1768_2,1806,5000,1495_2,1800,5500,9000_2,1793,5500,8228_2,1784,5500,8202_2,1770,5500,7916_2,1862,5500,7709_2,1824,5500,7650_2,1825,5500,7632_2,1806,5500,7567_2,1805,5500,4646_2,1791,5500,2711_2,1789,5500,1768_2,1772,5500,1621_2,1763,6000,9000_2,1860,6000,8228_2,1822,6000,8202_2,1819,6000,7916_2,1800,6000,7709_2,1799,6000,7695_2,1788,6000,7632_2,1786,6000,7616_2,1770,6000,4646_2,1751,6000,2711_2,1858,6000,1768_2,1818,6000,1732_2,1814,6500,9000_2,1795,6500,8228_2,1793,6500,8202_2,1784,6500,7968_2,1779,6500,7916_2,1767,6500,7730_2,1751,6500,7655_2,1853,6500,4646_2,1812,6500,2711_2,1811,6500,1825_2,1790,7000,9000_2,1789,7000,8228_2,1775,7000,8202_2,1773,7000,7968_2,1770,7000,7916_2,1763,7000,7757_2,1851,7000,7684_2,1807,7000,4646_2,1807,7000,2711_2,1786,7000,1901_2,1784,7500,9000_2,1776,7500,8228_2,1776,7500,8202_2,1774,7500,7968_2,1773,7500,7916_2,1849,7500,7777_2,1803,7500,7706_2,1803,7500,4646_2,1783,7500,2711_2,1783,7500,1961_2,1782,8000,9000_2,1782,8000,8228_2,1780,8000,8202_2,1778,8000,7968_2,1846,8000,7916_2,1802,8000,7790_2,1800,8000,7720_2,1800,8000,4646_2,1798,8000,2711_2,1790,8000,2003_2,1790,8500,9000_2,1843,8500,8228_2,1808,8500,8202_2,1805,8500,7968_2,1798,8500,7916_2,1847,8500,7798_2,1811,8500,7729_2,1811,8500,4646_2,1805,8500,2711_2,1845,8500,2028_2,1817,9000,9000_2,1816,9000,8228_2,1812,9000,8202_2,1844,9000,7968_2,1818,9000,7916_2,1818,9000,7801_2,1818,9000,7732_2,1846,9000,4646_2,1827,9000,2711_2,1827,9000,2037_2,1826,9500,9000_2,1846,9500,8228_2,1830,9500,8202_2,1830,9500,7968_2,1830,9500,7916_2,1842,9500,7883_2,1839,9500,7823_2,1839,9500,4646_2,1839,9500,2711_2,1842,9500,2335_2,1844,10000,9000_2,1844,10000,8228_2,1844,10000,8202_2,1845,10000,8185_2,1849,10000,8154_2,1849,10000,4646_2,1849,10000,4209_2,1846,10500,9000_2,1857,10500,8285_2,1857,10500,8264_2,1857,10500,5304_2,1845,11000,9000_2,1864,11000,8335_2,1864,11000,8319_2,1865,11000,5971_2,1844,11500,9000_2,1868,11500,8364_2,1868,11500,8352_2,1872,11500,6406_2,1845,12000,9000_2,1877,12000,8384_2,1877,12000,8373_2,1881,12000,6707_2,1844,12500,9000_2,1884,12500,8397_2,1884,12500,8388_2,1884,12500,6924_2,1845,13000,9000_2,1885,13000,8407_2,1885,13000,8399_2,1890,13000,7085_2,1844,13500,9000_2,1889,13500,8415_2,1890,13500,8407_2,1892,13500,7208_2,1843,14000,9000_2,1894,14000,8421_2,1894,14000,8414_2,1902,14000,7304_2,1850,14500,9000_2,1901,14500,8425_2,1901,14500,8419_2,1907,14500,7379_2,1853,15000,9000_2,1908,15000,8429_2,1908,15000,8423_2,1920,15000,7438_2,1856,15500,9000_2,1919,15500,8431_2,1918,15500,8426_2,1926,15500,7484_2,1859,16000,9000_2,1919,16000,8434_2,1919,16000,8428_2,1934,16000,7519_2,1863,16500,9000_2,1927,16500,8435_2,1928,16500,8430_2,1934,16500,7545_2,1864,17000,9000_2,1931,17000,8436_2,1934,17000,8431_2,1946,17000,7562_2,1868,17500,9000_2,1938,17500,8437_2,1938,17500,8431_2,1952,17500,7573_2,1873,18000,9000_2,1942,18000,8437_2,1942,18000,8432_2,1959,18000,7576_2,1874,18500,9000_2,1949,18500,8437_2,1949,18500,8431_2,1954,18500,7573_2,1878,19000,9000_2,1948,19000,8436_2,1948,19000,8431_2,1955,19000,7562_2,1880,19500,9000_2,1947,19500,8435_2,1949,19500,8430_2,1958,19500,7545_2,1879,20000,9000_2,1947,20000,8434_2,1947,20000,8428_2,1958,20000,7519_2,1880,20500,9000_2,1944,20500,8431_2,1944,20500,8426_2,1953,20500,7484_2,1884,21000,9000_2,1942,21000,8429_2,1942,21000,8423_2,1954,21000,7438_2,1885,21500,9000_2,1944,21500,8425_2,1944,21500,8419_2,1953,21500,7379_2,1888,22000,9000_2,1939,22000,8421_2,1941,22000,8414_2,1952,22000,7304_2,1891,22500,9000_2,1939,22500,8415_2,1939,22500,8407_2,1947,22500,7208_2,1893,23000,9000_2,1936,23000,8407_2,1936,23000,8399_2,1945,23000,7085_2,1894,23500,9000_2,1934,23500,8397_2,1934,23500,8388_2,1940,23500,6924_2,1896,24000,9000_2,1928,24000,8384_2,1930,24000,8374_2,1936,24000,6715_2,1899,24500,9000_2,1924,24500,8389_2,1927,24500,8379_2,1936,24500,6789_2,1900,25000,9000_2,1927,25000,8393_2,1924,25000,8383_2,1933,25000,6846_2,1900,25500,9000_2,1920,25500,8395_2,1920,25500,8386_2,1934,25500,6888_2,1902,26000,9000_2,1920,26000,8397_2,1920,26000,8388_2,1934,26000,6918_2,1903,26500,9000_2,1917,26500,8398_2,1917,26500,8389_2,1932,26500,6935_2,1903,27000,9000_2,1915,27000,8399_2,1915,27000,8389_2,1929,27000,6940_2,1902,27500,9000_2,1916,27500,8398_2,1916,27500,8389_2,1932,27500,6935_2,1901,28000,9000_2,1912,28000,8397_2,1914,28000,8388_2,1929,28000,6918_2,1901,28500,9000_2,1910,28500,8395_2,1911,28500,8386_2,1929,28500,6888_2,1899,29000,9000_2,1905,29000,8393_2,1908,29000,8383_2,1924,29000,6846_2,1897,29500,9000_2,1900,29500,8389_2,1902,29500,8379_2,1904,29500,6789_2,1904,30000,9000_2,1924,30000,8384_2,1924,30000,8374_2,1894,30000,6715_2,1894,30500,9000_2,1895,30500,8378_2,1897,30500,8367_2,1900,30500,6620_2,1909,31000,9000_2,1932,31000,8371_2,1893,31000,8359_2,1893,31000,6500_2,1893,31500,9000_2,1894,31500,8361_2,1894,31500,8348_2,1898,31500,6349_2,1899,32000,9000_2,1966,32000,8348_2,1966,32000,8333_2,1893,32000,6157_2,1891,32500,9000_2,1891,32500,8331_2,1891,32500,8315_2,1908,32500,5910_2,1940,33000,9000_2,1940,33000,8307_2,1951,33000,8289_2,1951,33000,5589_2,1984,33500,9000_2,2053,33500,8274_2,2053,33500,8252_2,1891,33500,5163";
	public Double x;
	public Double y;
	public Double z;
	public int id;
	
	
	
	public ceshi() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ceshi(Double x, Double y, Double z, int id) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.id = id;
	}



	public static List<ceshi> getPoint() {
		String[] strms=strn.split("_");
		List<ceshi> li=new ArrayList<ceshi>();
		for(String strl:strms) {
			String[] sss=strl.split(",");
			if(sss.length==4) {
				Double[] d=new Double[4];
				for(int i=0;i<4;i++) {
					if(i>=2) {
						Double ds=Double.valueOf(sss[i])/100;
						d[i]=ds;
					}else {
						Double ds=Double.valueOf(sss[i]);
						d[i]=ds;
					}
					
				}
				ceshi ce=new ceshi();
				ce.x=d[2];
				ce.y=d[3];
				ce.z=d[1];
				li.add(ce);
			}
		}
		List<ceshi> list=new ArrayList<ceshi>();
		for(int i=0;i<li.size();i++) {
			ceshi c=li.get(i);
			Double m=c.z*Math.cos(Math.toRadians(c.y));
			
		
			Double x=m*Math.sin(Math.toRadians(c.x));
			Double y=m*Math.cos(Math.toRadians(c.x));
			Double z=-1*c.z*Math.sin(Math.toRadians(c.y));
			
			x=m1(x);
			y=m1(y);
			z=m1(z);
			ceshi c1=new ceshi();
			c1.x=x;
			c1.y=y;
			c1.z=z;
			c1.id=i;
			list.add(c1);
		}
		return list;
			
	}
	

	
	public static List<ceshi> getSxPoint(List<ceshi> list,int index) {
		Set<Integer> set=new HashSet<Integer>();
		ceshi a=list.get(index);
		for(int i=index+1;i<list.size();i++) {
			ceshi b=list.get(i);
			double x=a.x-b.x;
			double y=a.y-b.y;
			double z=a.z-b.z;
			double re=getTan(x,y,z);
			if(re>1) {
				set.add(i);
			}
		}
		List<ceshi> li=new ArrayList<ceshi>();
		for(int idx:set) {
			li.add(list.get(idx));
		}
		list.removeAll(li);
		index++;
		if(index>=list.size()-1) {
			return list;
		}else {
			List<ceshi> re=getSxPoint(list,index);
			return re;
		}
	}
	
	
	public static double getTan(double x,double y,double z) {
//		System.out.println(x+","+y+","+z+","+(Math.abs(z)/Math.sqrt(Math.pow(x,2)+Math.pow(y,2))));
		return Math.abs(z)/Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	} 
	
	
	private static List<List<ceshi>> SxPoint() {
		List<ceshi> li=getPoint();
		List<List<ceshi>> sanjiaos=new ArrayList<List<ceshi>>();
		for(int i=0;i<li.size();i++) {
			ceshi c=li.get(i);
			DistanceId distance1=null;
			DistanceId distance2=null;
			for(int j=0;j<li.size();j++) {
				if(j==i) {
					continue;
				}
				ceshi cj=li.get(j);
				Double ds=getDistance(c, cj);
				if(distance1==null) {
					distance1=new DistanceId(ds, j);
				}
				else if(distance2==null) {
					if(ds<distance1.dis) {
						distance2=distance1;
						distance1=new DistanceId(ds, j);
					}else {
						distance2=new DistanceId(ds, j);
					}
				}else {
					if(ds<distance2.dis) {
						if(ds<distance1.dis) {
							distance2=distance1;
							distance1=new DistanceId(ds, j);
						}else {
							distance2=new DistanceId(ds, j);
						}
					}
				}
			}
			List<ceshi> sanjiao=new ArrayList<ceshi>();
			sanjiao.add(c);
			sanjiao.add(li.get(distance1.id));
			sanjiao.add(li.get(distance2.id));
			sanjiaos.add(sanjiao);
		}
		return sanjiaos;
	}
	
	
	
	private static List<List<ceshi>> SxPoint2() {
		List<ceshi> li=getPoint();
		List<List<ceshi>> sanjiaos=new ArrayList<List<ceshi>>();
		for(int i=0;i<li.size();i++) {
			ceshi c=li.get(i);
			DistanceId distance=null;
			for(int j=0;j<li.size();j++) {
				if(j==i) {
					continue;
				}
				ceshi cj=li.get(j);
				Double ds=getDistance(c, cj);
				if(distance==null) {
					distance=new DistanceId(ds, j);
				}
				else {
					if(ds<distance.dis) {
						distance=new DistanceId(ds, j);
					}
				}
			}
			List<ceshi> sanjiao=new ArrayList<ceshi>();
			sanjiao.add(c);
			sanjiao.add(li.get(distance.id));
			sanjiaos.add(sanjiao);
		}
		return sanjiaos;
	}
	
	
	
	
	
	
	public static void surfaceSx() {
		List<List<ceshi>> sanjiaos=SxPoint2();
		Set<Integer> set=new HashSet<Integer>();
		for(List<ceshi> li:sanjiaos) {
			ceshi a=li.get(0);
			ceshi b=li.get(1);
			ceshi ab=new ceshi(a.x-b.x,a.y-b.y,a.z-b.z,0);
//			//System.out.println(ab.x+","+ab.y+","+ab.z);
			Double mytan=Math.abs(ab.z)/Math.sqrt(Math.pow(ab.x,2)+Math.pow(ab.y,2));
			if(mytan>2) {
//				//System.out.println(mytan+"   id:"+a.id+","+b.id);
				set.add(a.id);
				set.add(b.id);
			}
			
		}
		//System.out.println("setsize:"+set.size());
		List<ceshi> mm=getPoint();
		//System.out.println("before size:"+mm.size());
		List<ceshi> removes=new ArrayList<ceshi>();
		for(int id:set) {
			removes.add(mm.get(id));
		}
		mm.removeAll(removes);
		//System.out.println("after size:"+mm.size());
		String[] strs=new String[mm.size()];
		for(int i=0;i<mm.size();i++) {
			ceshi pi=mm.get(i);
			strs[i]="["+pi.x+","+pi.y+","+pi.z+"]";
		}
		//System.out.println(Arrays.toString(strs));
		
	}

	
	
	private static String[] getResult(List<ceshi> mm) {
		String[] strs=new String[mm.size()];
		for(int i=0;i<mm.size();i++) {
			ceshi pi=mm.get(i);
			strs[i]="["+pi.x+","+pi.y+","+pi.z+"]";
		}
		return strs;
	}
	
	
	
	private static Double getDistance(ceshi c1,ceshi c2) {
		return Math.pow(c1.x-c2.x,2)+Math.pow(c1.y-c2.y,2)+Math.pow(c1.z-c2.z,2);
	}
	
	
	
	
	
	public static void main(String[] args) {
		List<ceshi> list=getPoint();
//		surfaceSx();
		List<Integer> li=getMySx(list,1.2);
		
		for(int i:li) {
			if(i==456) {
				System.out.println("1111aaaa");
			}
			
		}
		
		//System.out.println("--:"+li.size());
		Set<Integer> set=new HashSet<Integer>();
		for(Integer idx:li) {
			set.add(idx);
		}
		List<ceshi> rems=new ArrayList<ceshi>();
		for(int i:set) {
			rems.add(list.get(i));
		}
		
		
//		//System.out.println(set.size());
//		
//		List<MySort> ms=new ArrayList<MySort>();
//		for(int i:li) {
//			if(i==456) {
//				System.out.println("1111aaaa");
//			}
//			
//		}
//		for(int idx:set) {
//			int c=0;
//			for(int indx:li) {
//				if(indx==idx) {
//					
//					c++;
//					if(indx==456) {
//						System.out.println("c:"+c);
//					}
//				}
//			}
////			//System.out.println(idx+","+c);
//			MySort m=new MySort(idx, c);
//			ms.add(m);
//		}
//		//System.out.println("sdfsf:"+ms.size());
//		
//		//这这是tm的大坑啊    int 和 integer  之间用的时候一定慎重
//		Collections.sort(ms, new Comparator<MySort>() {
//
//
//			@Override
//			public int compare(MySort o1, MySort o2) {
//				if(o1.count>o2.count) {
//					return -1;
//				}else if(o1.count==o2.count) {
//					return 0;
//				}else {
//					return 1;
//				}
//			}
//			
//		});
//		
//		for(MySort msss:ms) {
////			System.out.println(msss.id+","+msss.count);
//		}
//		
//		
//		int count=ms.get(ms.size()/2).count;
//		//System.out.println(count);
//		System.out.println(ms.size());
//		Set<Integer> removeSets=new HashSet<Integer>();
//		for(MySort m:ms) {
//			if(m.count>=count) {
//				removeSets.add(m.id);
//			}
//		}
//		
//		
//		List<ceshi> rems=new ArrayList<ceshi>();
//		
//		for(int id:removeSets) {
//			rems.add(list.get(id));
//		}
//		//System.out.println(rems.size());
//		
		list.removeAll(rems);
		String[] strs=getResult(list);
		System.out.println(strs.length);
		System.out.println(Arrays.toString(strs));
		
		
		
//		List<ceshi> li=getSxPoint(list,0);
//		String[] strs=getResult(li);
//		//System.out.println(Arrays.toString(strs));
////		//System.out.println(new Date().getTime());
//		String str="http://localhost:8080/grm/api/stockChanges";
//		String[] strs=str.split("/");
////		//System.out.println(strs[strs.length-1]);
//		
//		
//		
//		String[] strms=strn.split("_");
//		List<ceshi> li=new ArrayList<ceshi>();
//		for(String strl:strms) {
////			//System.out.println(strl);
//			String[] sss=strl.split(",");
//			if(sss.length==4) {
//				Double[] d=new Double[4];
//				for(int i=0;i<4;i++) {
//					if(i>=2) {
//						Double ds=Double.valueOf(sss[i])/100;
//						d[i]=ds;
//					}else {
//						Double ds=Double.valueOf(sss[i]);
//						d[i]=ds;
//					}
//					
//				}
////				//System.out.println(Arrays.toString(d));
//				ceshi ce=new ceshi();
//				ce.x=d[2];
//				ce.y=d[3];
//				ce.z=d[1];
//				li.add(ce);
//			}
//			
//		}
//		String[] stss=new String[li.size()];
//		
//		for(int i=0;i<li.size();i++) {
//			
////			Math.toRadians()
//			
//			
//			ceshi c=li.get(i);
//			Double m=c.z*Math.cos(Math.toRadians(c.y));
//			
//		
//			Double x=m*Math.sin(Math.toRadians(c.x));
//			Double y=m*Math.cos(Math.toRadians(c.x));
//			Double z=-1*c.z*Math.sin(Math.toRadians(c.y));
//			
//			x=m1(x);
//			y=m1(y);
//			z=m1(z);
//			
//			stss[i]="["+x+","+y+","+z+"]";
//		}
//		//System.out.println(Arrays.toString(stss));
//
//		
////		var x = points_array[i][2]/100;
////    	var y = points_array[i][3]/100;
////    	var z = points_array[i][1];
////    	if (z > 60000 || z < 100) {
////    		continue;
////    	}
////    	var m = z*Math.cos((2*Math.PI / 360)*y);
////    	formatted_array.z.push(-z*Math.sin((2*Math.PI / 360)*y));
////    	formatted_array.x.push(m*Math.sin((2*Math.PI / 360)*x));
////    	formatted_array.y.push(m*Math.cos((2*Math.PI / 360)*x));
	}
	
	
	public static List<Integer> getMySx(List<ceshi> list,double qx){
		List<Integer> li=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			ceshi ci=list.get(i);
			for(int j=0;j<list.size();j++) {
				if(j==i) {
					continue;
				}
				ceshi cj=list.get(j);
				double x=ci.x-cj.x;
				double y=ci.y-cj.y;
				double z=ci.z-cj.z;
				double tan=getTan(x, y, z);
				if(tan>qx) {
					if(ci.z>cj.z) {
						li.add(i);
						
					}else {
						li.add(j);
					
					}
				}
			}
		}
		return li;
	}
	
	
	
	public static Double m1(Double f) {
		 BigDecimal bg = new BigDecimal(f);
		 Double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		 return  f1;
	}
}
