package com.alysoft.algo.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GladiatorWin
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        while (t > 0)
        {
        	int n = Integer.parseInt(br.readLine().trim());
        	int[] villainStrengths = new int[n];
            int[] playersEnergies = new int[n];
            
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            
            for (int i = 0; i<n; i++) {
            	villainStrengths[i] = Integer.parseInt(arrayValues[i].trim());
            }
            
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            
            for (int i = 0; i<n; i++) {
            	playersEnergies[i] = Integer.parseInt(arrayValues[i].trim());
            }
            
            String winStatus = getBattleStatus(villainStrengths, playersEnergies, n);
			System.out.println(winStatus);
            t--;
        }
	}

	public static String getBattleStatus(int[] villainStrengths, int[] playersEnergies, int n)
	{
		String battleStatus = "WIN";
		int playerIndex = 0;
		Arrays.sort(villainStrengths);
		Arrays.sort(playersEnergies);
		while (playerIndex < n) {
			if (playersEnergies[playerIndex] <= villainStrengths[playerIndex]) {
				battleStatus = "LOSE";
				break;
			}
			playerIndex++;
		}
		return battleStatus;
	}
}
