package lifegame;

/*
*Cell���ʾһ������ָ������ 
  *��� ��ǰ���ӵĴ��� 
  *��¼ÿ������״̬�Ķ�ά���� 
  *��һ������ÿ�����Ӵ���һ��ϸ��
*/
public class Cell {
	public int maxLength;// ����ĳ���
	public int maxWidth;// ����Ŀ��
	public int nowGeneration;// ��ǰϸ������Ĵ���
	public int[][] grid;// һ�����ݴ���һ�����λ�õ�ϸ��,0��������1�����
	// public boolean isBring = false;// ���ڲ����Ƿ�����cell
	/*
	 * ���캯������ʼ��һ��������������ϸ��״̬��Ϊ��
	 */

	public Cell(int maxLength, int maxWidth) {
		this.maxLength = maxLength;
		this.maxWidth = maxWidth;
		nowGeneration = 0;// Ĭ�ϵ�ǰ����Ϊ0
		// isBring = true;
		// ������ϸ����״̬���г�ʼ��
		grid = new int[maxLength + 2][maxWidth + 2];
		for (int i = 0; i <= maxLength + 1; i++) {
			for (int j = 0; j <= maxWidth + 1; j++) {
				grid[i][j] = 0;
			}
		}
	}

	/*
	 * ͨ��������ά�����ֵ������ĳ��λ�õ�ϸ����״̬�� ����ʵ��ͨ��������ø�����ϸ��״̬�ĸ߼�����
	 */
	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	/*
	 * ��ȡ�����ж�ά�����ֵ��ͼ�λ���ʾ������������ϸ����״̬�� ����ʵ��ͼ�λ���ʾ��ϸ��״̬�ĸ߼�����
	 */
	public int[][] getGrid() {
		return grid;
	}

	/*
	 * ���ڶԵ�ǰ�����������ã����ʲ��ı�������ϸ��������ֵ
	 */
	public void setNowGeneration(int nowGeneration) {
		this.nowGeneration = nowGeneration;
	}

	/*
	 * ���ڷ��ʲ���ȡ������ϸ��������ֵ
	 */
	public int getNowGeneration() {
		return nowGeneration;

	}

	// �����ʼ��ϸ����״̬
	public void randomCell() {
		for (int i = 1; i <= maxLength; i++)
			for (int j = 1; j <= maxWidth; j++)
				grid[i][j] = Math.random() > 0.5 ? 1 : 0;
	}

	// ϸ�����㣬����ϸ��״̬��0
	public void deleteAllCell() {
		for (int i = 1; i < maxLength; i++) {
			{
				for (int j = 1; j < maxWidth; j++)
					grid[i][j] = 0;
			}
		}
	}

	/*
	 * ���ܣ�����getNeighborCount(i, j)���ص�ϸ����Χϸ��״̬��ֵ ���ݹ�����������������һ����ϸ��״̬�Ķ�ά����
	 * ����ֵ�������е�int[][] grid������һ����ɷ���
	 */

	public void update() {
		int[][] newGrid = new int[maxLength + 2][maxWidth + 2];
		for (int i = 1; i <= maxLength; i++)
			for (int j = 1; j <= maxWidth; j++)
				switch (getNeighborCount(i, j)) {
				case 2:
					newGrid[i][j] = grid[i][j];// ϸ��״̬���ֲ���
					break;
				case 3:
					newGrid[i][j] = 1;// ��ǰϸ��״̬��Ϊ1
					break;
				default:
					newGrid[i][j] = 0;// ��ǰϸ��״̬��Ϊ0
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

	// ��ȡϸ�����ھ�����
	private int getNeighborCount(int i1, int j1) {
		int count = 0;
		for (int i = i1 - 1; i <= i1 + 1; i++) {
			for (int j = j1 - 1; j <= j1 + 1; j++) {
				count += grid[i][j];// ����ھӻ����ţ��ھ������+1
			}

		}
		count -= grid[i1][j1]; // ÿ��ϸ�������Լ����ھӣ������ϸ�������ţ��ھ���-1.
		return count;
	}
}