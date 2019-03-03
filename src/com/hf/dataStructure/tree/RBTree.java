package com.hf.dataStructure.tree;

/**
 * @author: huangfan
 * @date: 2019/2/23 10:59
 * @desc: 红黑树实现
 */
public class RBTree<T extends Comparable<T>> {

    //节点内部类
    class TreeNode<T extends Comparable<T>>{
        TreeNode<T> parent;//父节点
        TreeNode<T> left;//左孩子
        TreeNode<T> right;//有孩子
        boolean color;//颜色
        T key,value;//键值
        //构造方法
        public TreeNode(T key,T value,TreeNode parent,TreeNode left,TreeNode right,boolean color){
            this.key=key;
            this.value=value;
            if (parent!=null)
                this.parent=parent;
            this.left=left;
            this.right=right;
            this.color=color;
        }
    }

    //一个红黑树有一个根节点
    private TreeNode<T> root;

    //定义红黑颜色 ，因为只有两种，所以用true false 表示
    private static final boolean RED=true;
    private static final boolean BLACK=false;

    /**
     * 红黑树的基本操作包括 ：添加、删除、旋转（旋转又分左旋和右旋）
     */
    /*
     * 对红黑树的节点(x)进行左旋转 将x变成其右孩子的一个左节点
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                             px
     *     /                              /
     *    x                              y
     *   / \      --(左旋)->>>          / \                #
     *  lx  y                          x  ry
     *     / \                        / \
     *    ly ry                     lx  ly
     *
     */
    private void leftRotate(TreeNode<T> x){
        //存储x的右孩子
        TreeNode<T> y=x.right;

        //设置x的右孩子为y的左孩子,如果左孩子非空，则将y左孩子的父亲设置为x
        x.right=y.left;
        if (y.left!=null)
            y.left.parent=x;
        //将x的父亲设置为y的父亲
        y.parent=x.parent;
        if (x.parent==null){
            this.root=y;//如果x是根节点，则将y设置为根节点
        }else{
            if (x.parent.left==x)
                y.parent.left=y;//如果x为其父节点的左节点，则将y也设置成其父节点的左孩子，下类同
            if (x.parent.right==x)
                y.parent.right=y;
        }
        y.left=x;//设置x为y的左节点
        x.parent=y;//设置y为x的父节点

        //综上，左旋后，改变关系的节点里面的属性都要变，更换指针所指方向
    }

        /*
     * 对红黑树的节点(Y)进行右旋转 将y变成其左孩子的一个右节点
     *
     * 左旋示意图(对节点Y进行右旋)：
     *      px                             px
     *     /                              /
     *    x                              y
     *   / \      <<<--(右旋)-          / \                #
     *  lx  y                          x  ry
     *     / \                        / \
     *    ly ry                     lx  ly
     *
     */
     private void rightRotate(TreeNode<T> y){
         //存储y的左节点
         TreeNode<T> x=y.left;
         //x的右孩子变成y的左孩子,如果x的右孩子不为空，则将y设置成x右孩子的父节点
         y.left=x.right;
         if (x.right!=null)
             x.right.parent=y;
         //将y的父节点设置成x的父节点
         x.parent=y.parent;
         if (y.parent==null) {
             this.root = x;//如果y的父节点为空，则将x设置为根节点
         }else{
             if (y.parent.left==y)
                 x.parent.left=x; //如果y为其父节点的左孩子，则将x设置为其父节点的左孩子，下类同
             if (y.parent.right==y)
                 x.parent.right=x;
         }
         y.parent=x;//将y的父节点设置成x
         x.right=y;//将x的右孩子设置成y
     }

    /**
     * 添加
     *   第一步，将红黑树当作一棵查找二叉树进行插入（查找二叉树：每个节点的值大于其左子树的值小于其右子树的值）;
     *   第二步，将插入节点着色为红色
     *   第三步，进行一系列旋转操作使之成为红黑树
     * @param node
     */
     public void insert(TreeNode<T> node){
         if (node!=null)
             insertNode(node);
     }
     private void insertNode(TreeNode<T> node){
         //第一步，将红黑树当作一棵查找二叉树进行插入（查找二叉树：每个节点的值大于其左子树的值小于其右子树的值）
         TreeNode<T> x=this.root;
         TreeNode<T> y=null;
         int com=0;
         while (x!=null){//这一步是从根节点开始遍历，往下寻找，根据与每一个节点比较大小，寻找要插入位置的父节点
             y=x;//此处y类似一个指针的作用，指向那个父节点
             com=node.key.compareTo(x.key);
             if (com<0) //node比x小,y需要指向x的左子树
                 x=x.left;
             if (com>0)
                 x=x.right;
         }
         node.parent=y;
         if (y!=null){
             com=node.key.compareTo(y.key);
             if (com<0) //设置node为左子树
                y.left=node;
             if (com>0)
                 y.right=node;
             else
                 y.value=node.value;//若相等，则进行值的覆盖
         }else{
             this.root=node;
         }
         //第二步，将插入节点着色为红色
         node.color=RED;
         //第三步，进行一系列旋转操作使之成为红黑树
         insertFixUp(node);
     }
     private void insertFixUp(TreeNode<T> node){
         TreeNode<T> parent,grandpa;//父亲节点和祖父节点
         //插入时分六种情况
         //如果父亲节点存在，且颜色为红色，此时违背特性4；若父亲节点为黑色，则不予考虑
         while((parent=parentOf(node))!=null&&isRed(parent)){
             //若父亲节点是爷爷节点的左子树
             grandpa=parentOf(parent);
             if (grandpa.left==parent){
                 TreeNode<T> uncle=grandpa.right;
                 if (isRed(uncle)){//叔叔节点是红色
                    setColor(parent,BLACK);
                    setColor(uncle,BLACK);
                    setColor(grandpa,RED);
                    node=grandpa;
                    continue;
                 }
                 if (parent.right==node){
                     leftRotate(parent);
                 }
                 if (parent.left==node){
                     setColor(parent,BLACK);
                     setColor(uncle,BLACK);
                     rightRotate(grandpa);
                 }
             }
             if (grandpa.right==parent){
                 TreeNode<T> uncle=grandpa.left;
                 if (isRed(uncle)){
                     setColor(parent,BLACK);
                     setColor(uncle,BLACK);
                     setColor(grandpa,RED);
                     node=grandpa;
                     continue;
                 }
                 if (parent.right==node){
                     setColor(parent,BLACK);
                     setColor(uncle,BLACK);
                     leftRotate(grandpa);
                 }
                 if (parent.left==node){
                     rightRotate(parent);
                 }
             }
         }

     }

    /**
     * 查找父节点
     * @param node
     * @return
     */
     private TreeNode<T> parentOf(TreeNode<T> node){
        return node.parent;
     }

    /**
     * 设置节点颜色
     * @param node
     * @param color
     */
     private void setColor(TreeNode<T> node,boolean color){
         node.color=color;
     }
     private boolean isRed(TreeNode<T> node){
         if (node.color=RED)
             return true;
         else
             return false;
     }
     //删除的实现过于复杂，暂不研究

    /**
     * 三种遍历方式
     */
    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(TreeNode<T> node){
        if (node!=null){
            System.out.println(node.key+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    /**
     * 中序遍历
     */
    public void midOrder(){
        midOrder(root);
    }
    private void midOrder(TreeNode<T> node){
        if (node!=null){
            midOrder(node.left);
            System.out.println(node.key+" ");
            midOrder(node.right);
        }
    }
    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(TreeNode<T> node){
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key+" ");
    }
    /**
     * 查找节点 时间复杂度：O(logn)
     *      查找某个节点必须从根节点开始寻找
     *      若查找值比当前节点值大，则搜索右子树，相等则停止搜索(终止条件)，小于则搜索左子树
     */
    public TreeNode<T> search(TreeNode<T> node){
        TreeNode<T> current=root;
        int com;
        while (current!=null){
            com=current.value.compareTo(node.value);
            if (com<0){
                current=current.left;
            }
            if (com>0){
               current=current.right;
            }
            if (com==0){
                return current;
            }
        }
        return null;
    }
    /**
     * 查找最小值，先找根的左节点，再找这个左节点的左节点，直到找到没有左节点的节点
     */
    public TreeNode<T> findMin(){
        TreeNode<T> current=root;
        TreeNode<T> minNode=current;
        while (current!=null){
            current=current.left;
        }
        return minNode;
    }

    /**
     * 找最大值
     * @return
     */
    public TreeNode<T> findMax(){
        TreeNode<T> current=root;
        TreeNode<T> maxNode=current;
        while (current!=null){
            current=current.right;
        }
        return maxNode;
    }
}
