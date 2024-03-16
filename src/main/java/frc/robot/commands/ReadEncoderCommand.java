package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterClimberSubsystem;

public class ReadEncoderCommand extends Command {
    private ShooterClimberSubsystem shooterClimberSubsystem;

    public ReadEncoderCommand(ShooterClimberSubsystem shooterClimberSubsystem) {
        this.shooterClimberSubsystem = shooterClimberSubsystem;

        addRequirements(shooterClimberSubsystem);
    }

    @Override
    public void execute() {
        shooterClimberSubsystem.readAngle();

    }

    @Override
    public void end(boolean interrupted) {

    }
}
