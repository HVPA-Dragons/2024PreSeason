package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import edu.wpi.first.cameraserver.CameraServer;

// TODO figure out what other imports are needed

public class VisionSubsystem extends SubsystemBase {
    /*
     * private final PhotonCamera hullCam;
     * private final PhotonCamera shooterCam;
     * private final NetworkTable table;
     * private final NetworkTableInstance inst;
     * private double targetX;
     * private double targetY;
     * private double targetZ;
     * private double targetYaw;
     * private double targetToGoDistance;
     * private double targetArea;
     */

    public VisionSubsystem() {
        /*
         * hullCam = new PhotonCamera("hullcam");
         * shooterCam = new PhotonCamera("shootercam");
         * inst = NetworkTableInstance.getDefault();
         * table = inst.getTable("photonvision");
         */
    }

    public void updateVision() {
        /*
         * / targetX = table.getEntry("targetX").getDouble(0);
         * targetY = table.getEntry("targetY").getDouble(0);
         * targetZ = table.getEntry("targetZ").getDouble(0);
         * targetYaw = table.getEntry("targetYaw").getDouble(0);
         * targetToGoDistance = table.getEntry("targetToGoal").getDouble(0);
         * targetArea = table.getEntry("targetArea").getDouble(0);
         */
    }

    public void updateDashboard() {
        // TODO figure out what to do here
    }

    public void updateCamera() {
        // TODO figure out what to do here
    }

    public void setTarget(int tagId) {
        // table.getEntry("target").setNumber(tagId);
    }
}