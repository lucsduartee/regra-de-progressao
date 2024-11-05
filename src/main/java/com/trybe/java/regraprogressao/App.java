package com.trybe.java.regraprogressao;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * App.
 */
public class App {

  /**
   * Metodo main.
   */
  public static void main(String[] args) {
    // Da pra usar new Scanner(System.in).useDelimiter("\n")
    // O useLocale é pra poder ler o nextFloat()
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    System.out.print("Digite a quantidade de atividades para cadastrar: ");
    int activitiesCounter = scanner.nextInt();
    scanner.nextLine();  // Consumir a quebra de linha após o nextInt()

    String[] activities = new String[activitiesCounter];
    int[] activitiesWeight = new int[activitiesCounter];
    float[] activitiesScores = new float[activitiesCounter];

    for (int index = 0; index < activitiesCounter; index++) {
      int activityNumber = index + 1;
      System.out.print("Digite o nome da atividade " + activityNumber + ": ");
      String activityName = scanner.nextLine();
      activities[index] = activityName;

      System.out.print("Digite o peso da atividade " + activityNumber + ": ");
      int activityWeight = scanner.nextInt();
      activitiesWeight[index] = activityWeight;
      scanner.nextLine();

      System.out.print("Digite a nota obtida para " + activities[index] + ": ");
      float activityScore = scanner.nextFloat();
      activitiesScores[index] = activityScore;
      scanner.nextLine();
    }

    scanner.close();

    System.out.println("Atividades: " + Arrays.toString(activities));
    System.out.println("Pesos das atividades: " + Arrays.toString(activitiesWeight));
    System.out.println("Nota das atividades: " + Arrays.toString(activitiesScores));
    System.out.println("Soma dos pesos: " + Arrays.stream(activitiesWeight).sum());

    if (Arrays.stream(activitiesWeight).sum() != 100) {
      System.out.println("A soma dos pesos é diferente de 100!");
      return;
    }

    float sum = 0.0f;

    for (int index = 0; index < activitiesCounter; index++) {
      sum += activitiesScores[index] * activitiesWeight[index];
    }

    float averageScore = sum / 100;

    if (averageScore >= 85.0) {
      System.out.println("Parabéns! Você alcançou "
              + averageScore
              + "%! E temos o prazer de informar que você obteve aprovação!");
    } else if (averageScore < 85.0) {
      System.out.println(
              "Lamentamos informar que, com base na sua pontuação alcançada neste período, "
              + averageScore
              + "%, você não atingiu a pontuação mínima necessária para sua aprovação.");
    }
  }
}