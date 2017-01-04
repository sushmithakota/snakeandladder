import java.util.*;
class snakeandladder
{
public void mincount(int[] points,int n)
{
	int count=0,pos=0,min=99,j;
	for(int i=1;i<=6;i++)
	{
		pos=i;j=i;count=0;
		if(i==6)
			count=1;
		while(pos<30)
		{
		
			if(points[j]>(j+1))
			{
				pos=points[j];
				count++;
				j=pos;
				if(points[j]>(j+1))
				{
					pos=points[j];
					j=pos;
				}
			}
			else
				j++;
			if(j==(pos+6))
			{
				count++;
				pos=pos+6;
			}
			if((n-pos)<=12&&(n-pos)>0)
			{
				if((n-pos)<=6)
					count++;
				else
					count+=2;
				pos=n;
			}
			if(count<min && pos==n)
				min=count;
				
		}
		
	}
	System.out.println("minimum number of throws with ladders  "+min);
}
public int mincountsnake(int[] points,int n)
{
int count=0,pos=0,min=99,j,flag=0;

	for(int i=1;i<=6;i++)
	{
		pos=i;j=i;count=0;
		if(i==6)
			count=1;
		while(pos<n)
		{
		
			if(points[j]>(j+1)&&points[j]<=n)
			{
				pos=points[j];
				count++;
				j=pos;
				if(points[j]>(j+1))
				{
					pos=points[j];
					j=pos;
				}
			}
			else
				j++;
			if(j==(pos+6))
			{
				count++;
				pos=pos+6;
			}
			if((n-pos)<=12&&(n-pos)>0)
			{
				if((n-pos)<=6)
					count++;
				else
					count+=2;
				pos=n;
			}
			if(count<min && pos==n)
				min=count;
				
		}
		
	}
	return min;
	
	
}
public int mindist(int[] points,int n,int pos1)
{
	int count=0,pos=0,min=99,j;
	for(int i=1;i<=6;i++)
	{
		pos=pos1;j=pos1;count=0;
		if(i==6)
			count=1;
		while(pos<n)
		{
		
			if(points[j]>(j+1))
			{
				pos=points[j];
				count++;
				j=pos;
				if(points[j]>(j+1))
				{
					pos=points[j];
					j=pos;
				}
			}
			else
				j++;
			if(j==(pos+6))
			{
				count++;
				pos=pos+6;
			}
			if((n-pos)<=12&&(n-pos)>0)
			{
				if((n-pos)<=6)
					count++;
				else
					count+=2;
				pos=n;
			}
			if(count<min && pos==n)
				min=count;
				
		}
		
	}	
	return min;
}
public void count(int [] points,int n)
{
	int snakes=0,ladders=0,i=1;
	while(i<=30)
	{
		if(points[i]>i+1)
			ladders++;
		else 
			if(points[i]<i)
				snakes++;
		i++;
	}
	System.out.println("ladders: "+ladders+"  snakes:"+snakes);
}
public static void main(String args[])
{
	Scanner s=new Scanner(System.in);	
	System.out.println("enter the size of the board");
	int n=s.nextInt();
	int[] points=new int[n+1];
	//System.out.println("enter the number of ladders");
	//int l=s.nextInt();
	//System.out.println("enter the number of snakes");
	//int s1=s.nextInt();
	/*System.out.println("enter the snakes and ladders ");
	for(int i=1;i<=l;i++)
	{
		System.out.println("enter the source of ladder");
		int j=s.nextInt();
		System.out.println("enter the destination of ladder ");
		points[j]= s.nextInt();
	}
	for(int i=1;i<=s1;i++)
	{
		System.out.println("enter the source of snake");
		int j=s.nextInt();
		System.out.println("enter the destination of snake ");
		points[j]= s.nextInt();
	}
	System.out.println(n);*/
	points[3]=22;points[11]=26;points[5]=8;points[20]=29;
	points[27]=1;points[21]=9;points[17]=4;points[19]=7;
	points[0]=1;
	for(int i=1;i<n;i++)
	{
		//System.out.println(i);
		if(points[i]==0)
			points[i]=(i+1);
	}
	snakeandladder sl=new snakeandladder();
/*for(int i=0;i<=n;i++)
	System.out.println(points[i]);*/
	sl.mincount(points,n);
	int min=99,j=0;
	int[] count=new int[5];
	int count1;
	for(int i=1;i<n;i++)
	{
		if(points[i]<i+1)
		{		
		count[j++]=sl.mincountsnake(points,i);
		count1=sl.mindist(points,n,points[i]);
		if((count[j-1]+count1)<min)
			min=count[j-1]+count1;
		}
	}
	System.out.println("minimum number of throws with a snake bit  " + min);
}
}
