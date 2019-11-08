package frc.robot.commands;

import edu.wpi.first.wpilibj.experimental.command.SendableCommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrainr;

public class TankDrive extends SendableCommandBase {

  private Drivetrain drivetrain;

  public TankDrive(Drivetrain drivetrain) {

    this.drivetrain = drivetrain;  
    addRequirements(drivetrain);
    
  }

  public TankDrive(Drivetrainr drivetrainr) {
}

@Override
  public void execute() {

    drivetrain.setPower(Robot.oi.getLeftThrottle(), Robot.oi.getRightThrottle());

  }

}
