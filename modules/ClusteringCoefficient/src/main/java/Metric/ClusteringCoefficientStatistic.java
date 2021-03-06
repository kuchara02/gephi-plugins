package Metric;

import org.gephi.graph.api.*;
import org.gephi.statistics.spi.Statistics;
import org.gephi.utils.longtask.spi.LongTask;
import org.gephi.utils.progress.ProgressTicket;

public class ClusteringCoefficientStatistic implements Statistics, LongTask {

    private String report = "";
    public static boolean cancel = false;
    private ProgressTicket progressTicket;

    public void execute(GraphModel graphModel) {
        if (ClusteringCoefficientUI.triangleMethod) {
            TriangleClusteringCoefficientAlgorithm tcc = new TriangleClusteringCoefficientAlgorithm(graphModel);
            report = tcc.calculate();
        } else {
            ClusteringCoefficientAlgorithm cc = new ClusteringCoefficientAlgorithm(graphModel);
            report = cc.calculate();
        }
    }

    public String getReport() {
        return report;
    }

    public boolean cancel() {
        cancel = true;
        return true;
    }

    public void setProgressTicket(ProgressTicket progressTicket) {
        this.progressTicket = progressTicket;
    }
}