package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.math.controller.*;

public class ShooterClimberSubsystem extends SubsystemBase {
    private final CANSparkMax shooterMotor1;
    private final CANSparkMax shooterMotor2;
    private final Encoder shooterEncoder;
    private final CANSparkMax shooterAngleMotor1;
    private final CANSparkMax shooterAngleMotor2;
    private final DigitalInput shooterAngleZeroSensor;

    public ShooterClimberSubsystem() {
        shooterMotor1 = new CANSparkMax(Constants.ShooterConstants.kShooterMotor1Port, MotorType.kBrushless);
        shooterMotor2 = new CANSparkMax(Constants.ShooterConstants.kShooterMotor2Port, MotorType.kBrushless);
        shooterAngleMotor1 = new CANSparkMax(Constants.ShooterConstants.kShooterAngleMotor1Port, MotorType.kBrushless);
        shooterAngleMotor2 = new CANSparkMax(Constants.ShooterConstants.kShooterAngleMotor2Port, MotorType.kBrushless);
        shooterEncoder = new Encoder(6, 7);
        shooterAngleZeroSensor = new DigitalInput(0);
        shooterMotor1.setIdleMode(CANSparkMax.IdleMode.kBrake);
        shooterMotor2.setIdleMode(CANSparkMax.IdleMode.kBrake);
        shooterAngleMotor1.setIdleMode(CANSparkMax.IdleMode.kBrake);
        shooterAngleMotor2.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    public void AngleDown() {
        shooterAngleMotor1.set(-1);
        shooterAngleMotor2.set(1);

    }

    public void AngleUp() {
        shooterAngleMotor1.set(1);
        shooterAngleMotor2.set(-1);

    }

    public void HoldAngle() {

        shooterAngleMotor1.set(0);
        shooterAngleMotor2.set(0);
    }

    public void shootOnSpeaker() {
        shooterMotor1.set(1);
        shooterMotor2.set(1);
    }

    public void shootOnAmp() {
        shooterMotor1.set(1);
        shooterMotor2.set(1);
    }

    public void stopShooter() {
        shooterMotor1.set(0);
        shooterMotor2.set(0);

    }

    public void shootBack() {
        shooterMotor1.set(-0.2);
        shooterMotor2.set(-0.2);

    }

    public void readAngle() {
        shooterEncoder.getDistance();
    }

    public void resetAngleEncoder() {
        shooterEncoder.reset();
    }

    public void startupZero() {
        System.out.println("Sending Shooter Down");
        AngleDown();
        while (shooterAngleZeroSensor.get()) {
            System.out.println("Homing");
        }
        System.out.println("DONE!");
        HoldAngle();
        resetAngleEncoder();
    }

    public Command cShootOnSpeaker() {
        return this.runEnd(this::shootOnSpeaker, this::stopShooter);
    }

    public Command cShootOnAmp() {
        return this.runEnd(this::shootOnAmp, this::stopShooter);
    }

    public Command cShootBack() {
        return this.runEnd(this::shootBack, this::stopShooter);
    }

    public Command cAngleUp() {
        return this.runEnd(this::AngleUp, this::HoldAngle);
    }

    public Command cAngleDown() {
        return this.runEnd(this::AngleDown, this::HoldAngle);
    }

}
