package lifegame;

/*
*Cell类表示一个带有指定长度 
  *宽度 当前格子的代数 
  *记录每个格子状态的二维数组 
  *的一个网格，每个格子代表一个细胞
*/
public class Cell {
	public int maxLength;// 网格的长度
	public int maxWidth;// 网格的宽度
	public int nowGeneration;// 当前细胞网格的代数
	public int[][] grid;// 一个数据代表一个这个位置的细胞,0代表死，1代表活
	// public boolean isBring = false;// 用于测试是否生成cell
	/*
	 * 构造函数，初始化一个网格，其中所有细胞状态都为死
	 */

	public Cell(int maxLength, int maxWidth) {
		this.maxLength = maxLength;
		this.maxWidth = maxWidth;
		nowGeneration = 0;// 默认当前代数为0
		// isBring = true;
		// 对所有细胞的状态进行初始化
		grid = new int[maxLength + 2][maxWidth + 2];
		for (int i = 0; i <= maxLength + 1; i++) {
			for (int j = 0; j <= maxWidth + 1; j++) {
				grid[i][j] = 0;
			}
		}
	}

	/*
	 * 通过给定二维数组的值来设置某个位置的细胞的状态， 用于实现通过点击设置格子中细胞状态的高级功能
	 */
	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	/*
	 * 获取格子中二维数组的值来图形化显示的整个网格中细胞的状态， 用于实现图形化显示中细胞状态的高级功能
	 */
	public int[][] getGrid() {
		return grid;
	}

	/*
	 * 用于对当前代数进行设置，访问并改变网格中细胞代数的值
	 */
	public void setNowGeneration(int nowGeneration) {
		this.nowGeneration = nowGeneration;
	}

	/*
	 * 用于访问并获取网格中细胞代数的值
	 */
	public int getNowGeneration() {
		return nowGeneration;

	}

	// 随机初始化细胞的状态
	public void randomCell() {
		for (int i = 1; i <= maxLength; i++)
			for (int j = 1; j <= maxWidth; j++)
				grid[i][j] = Math.random() > 0.5 ? 1 : 0;
	}

	// 细胞清零，所有细胞状态归0
	public void deleteAllCell() {
		for (int i = 1; i < maxLength; i++) {
			{
				for (int j = 1; j < maxWidth; j++)
					grid[i][j] = 0;
			}
		}
	}

	/*
	 * 繁衍，根据getNeighborCount(i, j)返回的细胞周围细胞状态的值 依据规则在网格中生成下一代的细胞状态的二维数组
	 * 并赋值给网格中的int[][] grid代数加一，完成繁衍
	 */

	public void update() {
		int[][] newGrid = new int[maxLength + 2][maxWidth + 2];
		for (int i = 1; i <= maxLength; i++)
			for (int j = 1; j <= maxWidth; j++)
				switch (getNeighborCount(i, j)) {
				case 2:
					newGrid[i][j] = grid[i][j];// 细胞状态保持不变
					break;
				case 3:
					newGrid[i][j] = 1;// 当前细胞状态变为1
					break;
				default:
					newGrid[i][j] = 0;// 当前细胞状态变为0
				}
		/*
		 * for (int i = 1; i <= maxLength; i++) for (int j = 1; j <= maxWidth; j++)
		 * grid[i][j] = newGrid[i][j];
		 */
		setGrid(newGrid);
		nowGeneration++;
	}

	public static void main(String arg[]) {

	  Cell cell1 = new Cell(50, 70);
		cell1.randomCell();
		cell1.setNowGeneration(0);
		while (true) {
			cell1.update();
		}
		
	}

	// 获取细胞的邻居数量
	private int getNeighborCount(int i1, int j1) {
		int count = 0;
		for (int i = i1 - 1; i <= i1 + 1; i++) {
			for (int j = j1 - 1; j <= j1 + 1; j++) {
				count += grid[i][j];// 如果邻居还活着，邻居数便会+1
			}

		}
		count -= grid[i1][j1]; // 每个细胞不是自己的邻居，则如果细胞还活着，邻居数-1.
		return count;
	}
}