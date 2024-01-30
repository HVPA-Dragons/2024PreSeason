package frc.robot.subsystems;

import java.io.IOException;
import java.util.Optional;

import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
    public VisionSubsystem() throws IOException {
    }

    // This is throwing an error, but when putting it onto the robot it should be
    // fine
    // This is because the file is bundled with the photonvision download
    // So when we flash the rPI it should be fine... I think
    AprilTagFieldLayout aprilTagFieldLayout = AprilTagFieldLayout
            .loadFromResource(AprilTagFields.k2024Crescendo.m_resourceFile);

    // Forward Camera
    PhotonCamera cam = new PhotonCamera("testCamera");
    Transform3d robotToCam = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0, 0, 0));

    PhotonPoseEstimator photonPoseEstimator = new PhotonPoseEstimator(aprilTagFieldLayout,
            PoseStrategy.MULTI_TAG_PNP_ON_COPROCESSOR, cam, robotToCam);

    public Optional<EstimatedRobotPose> getRobotPose() {
        return photonPoseEstimator.update();
    }
}
