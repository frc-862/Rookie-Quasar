package frc.robot.commands;

import edu.wpi.first.wpilibj.experimental.command.SendableCommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends SendableCommandBase {

  private Drivetrain drivetrain;

  public TankDrive(Drivetrain drivetrain) {

    this.drivetrain = drivetrain;  
    addRequirements(drivetrain);
    
  }

  @Override
  public void execute() {

    drivetrain.setPower(Robot.oi.getLeftThrottle(), Robot.oi.getRightThrottle());

  }

}
