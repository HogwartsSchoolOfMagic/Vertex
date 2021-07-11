package io.github.hogwartsschoolofmagic.vertex;

import static javax.swing.SwingUtilities.invokeLater;

import io.github.hogwartsschoolofmagic.vertex.util.VertexUtil;

/**
 * A class to run the entire application.
 *
 * @author Vladislav [SmithyVL] Kuznetsov.
 * @since 0.1.0.
 */
public class VertexApplication {

  public static void main(String[] args) {
    Runnable runnable = VertexUtil::started;
    invokeLater(runnable);
  }
}