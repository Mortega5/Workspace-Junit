package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import sudoku.SudokuVerifier;

//@RunWith(Parameterized.class)
public class SudokuVerifierTest {
	private String sudoku;
	private String result;
	
//	public SudokuVerifierTest(String sudoku) {
//		this.sudoku = sudoku;
//	}
//	
//	@Parameters(name = "Test {index} : new SudokuVerifier({1}) = {0}")
//	public static Collection<Object[]> myData() {
//		String validSudoku ="547916238193284675628753491359421786462578913871639524916847352735162849284395167";
//		String noResolved= "547916238193284675628753491359421786462578913871639524916847352735162849284395165";
//		String validSudoku2 = "297534186468912735531678924924783561685491372173256849812345697756829413349167258";
//		String character_80 = "29753418646891273553167892492478356168549137217325684981234569775682941334916725";
//		String valid3 = "598172436671934852234658917859347261147269385362815749426781593783596124915423678";
//		String invali_78 = "297534186468912735531678924924783561685445372173256849812345697756829413349152";
//		return Arrays.asList(new Object[][] {
//				{validSudoku, validSudoku},
//				{noResolved, noResolved},
//				{validSudoku2, validSudoku2},
//				{character_80, character_80},
//				{valid3, valid3},
//				{invali_78, invali_78}
//		});
//	}

	@Test
	public void crearUnNuevoSudoku() {
		String valid3 = "598172436671934852234658917859347261147269385362815749426781593783596124915423678";
		String error = "Se intenta crear un sudoku, pero no se almacena el mismo que se quiere añadir";
		assertEquals(error, valid3, new SudokuVerifier(valid3).getCandidateSolution());
	}
	
	@Test
	public void comprobarNumeroCaracteres() {
		String invalid_78 = "297534186468912735531678924924783561685445372173256849812345697756829413349152";
		assertFalse(new SudokuVerifier(invalid_78).verifierSudoku());
		String validSudoku ="547916238193284675628753491359421786462578913871639524916847352735162849284395167";
		assertTrue(new SudokuVerifier(validSudoku).verifierSudoku());
		
	}

}
