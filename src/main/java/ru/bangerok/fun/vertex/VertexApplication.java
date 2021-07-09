package ru.bangerok.fun.vertex;

import static javax.swing.SwingUtilities.invokeLater;

import ru.bangerok.fun.vertex.util.VertexUtil;

/**
 * A class to run the entire application.
 *
 * @author Vladislav [Bangerok] Kuznetsov.
 * @since 0.1.0.
 */
public class VertexApplication {

  public static void main(String[] args) {
    Runnable runnable = VertexUtil::started;
    invokeLater(runnable);
  }
}