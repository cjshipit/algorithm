#include<iostream>
#include<queue>
//���int�� ���ֵ 
using namespace std ;
//��prim�㷨����С������ 
//�����ȶ��з����ֵ �����ҵ���Ȩֵ���ӵı� ����Ҫ 
class node{
	public: 
	int last ;
	int next ; 
	int weight ;
	//�º��� 
	node(int last,int next,int weight)
	{
		this->last = last;
		this->next = next;
		this->weight = weight ;
	}	
}; 
class cmp{
	public:
		bool operator()(const node& t1,const node& t2)const{
		//���< �����˴󶥶� >����С���� 
		return t1.weight < t2.weight ;
	} 		
};
int main(void){
    //����>> Ҫ�ӿո� > > 
    node n(1,2,3);
    node n1(1,2,5);
    node n2(1,2,4);
    node n3(2,3,100); 
    //cmp������з���һ�� �º��� (������()�����,�൱��cmp����������ʹ�� ) 
    priority_queue<node,vector<node>,cmp> q;
    q.push(n);
    q.push(n2);
    q.push(n3);
    q.push(n3);
    q.push(n3);
    while(q.empty()==false)
    {
    	cout<<q.top().weight<<endl;
    	q.pop();
    	
	}



} 
