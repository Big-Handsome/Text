package lifegame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private static Cell cell = new Cell(5, 5);

	@Before
	public void setUp() throws Exception {
		// cell.deleteAllCell();
	}

	/*
	 * @Test public void testCell() {
	 * 
	 * }
	 */
	@Test
	public void testSetGrid() {
		Cell testcell = new Cell(40, 50);
		int[][] test = new int[40][50];
		for (int i = 1; i < testcell.maxLength; i++)
			for (int j = 1; j < testcell.maxWidth; j++)
				test[i][j] = Math.random() > 0.5 ? 1 : 0;
		testcell.setGrid(test);
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				assertEquals(test[i][j], testcell.grid[i][j]);
			}
		}
		int[][] test2 = new int[40][50];
		for (int i = 1; i < testcell.maxLength; i++)
			for (int j = 1; j < testcell.maxWidth; j++)
				test2[i][j] = Math.random() > 0.5 ? 1 : 0;
		testcell.setGrid(test2);
		for (int i = 0; i < test2.length; i++) {
			for (int j = 0; j < test2[i].length; j++) {
				assertEquals(test2[i][j], testcell.grid[i][j]);
			}
		}

	}

	@Test
	public void testgetGrid() {
		Cell cell1 = new Cell(5, 5);
		int[][] a = { { 0, 0, 1, 0, 1 }, { 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 }, { 0, 0, 1, 0, 1 }, { 0, 0, 1, 0, 1 } };
		cell1.setGrid(a); // setGrid已完成测试
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				assertEquals(a[i][j], cell1.grid[i][j]);
			}
		}
		Cell cell2 = new Cell(4, 4);
		int[][] b = { { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 1, 1 }, { 0, 1, 1, 1 } };
		cell2.setGrid(b);
		for (int m = 0; m < b.length; m++) {
			for (int n = 0; n < b[m].length; n++) {
				assertEquals(b[m][n], cell2.grid[m][n]);
			}
		}
	}

	@Test
	public void testsetNowGeneration() {

		for (int i = 5; i <= 200; i++) {
			cell.setNowGeneration(i);
			assertEquals(i, cell.nowGeneration);
		}
	}

	@Test
	public void testgetNowGeneration() {
		for (int i = 5; i <= 200; i++) {
			cell.setNowGeneration(i);
			assertEquals(i, cell.getNowGeneration());
		}

	}

	@Test
	public void testRandomCell() {
		Cell cell1 = new Cell(60, 45);// cell()已完成测试
		for (int i = 0; i < 62; i++) {
			for (int j = 0; j < 47; j++) {
				assertEquals(0, cell1.grid[i][j]);
			}
		}
	}

	@Test
	public void testDeleteAllCell() {

		for (int i = 1; i < cell.maxLength; i++)
			for (int j = 1; j < cell.maxWidth; j++)
				assertEquals(0, cell.grid[i][j]);
	}

	@Test
	public void testUpdate() {
		fail("尚未实现");
	}
}
