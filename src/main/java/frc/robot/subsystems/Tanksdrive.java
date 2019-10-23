package frc.robot.subsystems;

import edu.wpi.first.wpilibj.experimental.command.SendableCommandBase;
import frc.robot.Robot;

public class Tanksdrive extends SendableCommandBase {
    
    private Drivetrain drivetrain;

    public Tanksdrive() {

    this.drivetrain = drivetrain;

    addRequirements(drivetrain);

}

@Override
public void execute()  {

    drivetrain.setPower(Robot.oi.getLeftThrottle(), Robot.oi.getRightThrottle() );

}

}

