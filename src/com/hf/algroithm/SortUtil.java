package com.hf.algroithm;

/**
 * @author: huangfan
 * @date: 2019/2/26 17:15
 * 各种排序算法
 */
public class SortUtil {

    /**
     * 堆排序 时间复杂度为O(nlogn)
     */
    static class HeapSort{
        public void HeapSort(int [] array){
            //第一步，无序数组构建堆
//            buildMaxHeap(array,array.length-1, array.length);
            //从最后一个节点开始向上寻找，找它所在的子树点，然后调整，把最大值作为父节
            int size=array.length;
            for (int j=0;j<size-1;j++){
                //完成一次建堆即可保证堆顶为最大值
                for (int i=size-j-1;i>=0;i--){
                    buildMaxHeap(array,i,size);
                }
                swap(array,j,size-j-1);//交换值，把最大值挪到后面
            }

        }
        private void buildMaxHeap(int[] array,int current,int size){
            if (current<size){
                int left=current*2+1;//左子节点下标
                int right=current*2+2;
                int max=current;//假设当前节点作为父节点，在其所在子树中是最大的
                if (left<size){//如果其左子节点存在
                    if (array[left]>array[max]){
                        max=left;//记录较大值的位置
                    }
                }
                if (right<size){//假设右子节点存在
                    if (array[right]>array[max]){
                        max=right;
                    }
                }
                if (current!=max){
                    swap(array,current,max);//交换两个的位置，这样就把较大值挪到了父节点
                    /*
                     * 交换完成后还要看子节点是否打破最大堆性质，
                     * 有可能原本父节点为80，右子节点为100，右子节点的左子节点为90，交换后80<90
                     */
                    buildMaxHeap(array,max,size);
                }
            }
        }
        private  void swap(int [] array,int x,int y){
            int temp=array[x];
            array[x]=array[y];
            array[y]=temp;
        }
    }

    /**
     * 归并排序 稳定好 效率高 适合大数据量
     */
    class mergeSort{
        public void mergeSort(int [] array,int left,int right){
            int mid=(left+right)/2;
            if (left<right){
                mergeSort(array,left,mid);
                mergeSort(array,mid+1,right);
                merge(array,left,mid,right);
            }
        }
        private void merge(int[] array,int left,int mid,int right){
            //mid 把array 分成两部分，这两部分一个一个元素的比较，小的放入到辅助数组中，完成一次归并
            if (right<left) return;
            int i=left;
            int j=mid+1;
            int [] temp=new int[right-left+1];
            int k=0;//辅助数组的下标
            while (i<=mid&&j<=right){
                if (array[i]<array[j]){
                    temp[k++]=array[i++];
                }
                if (array[j]<array[i]){
                    temp[k++]=array[j++];
                }
            }
            //分割成两部分后，有可能一个长一个短，把长的中未参与比较的那部分放入辅助数组中
           while(i<=mid){
                temp[k++]=array[i++];
            }
            while (j<=right){
               temp[k++]=array[j++];
            }
            //把辅助数组中的数据放入到array中
            for (int x=left;x<temp.length;x++){
                array[x]=temp[x];
            }

        }
    }
}
