package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {

    public static Drivetrain drivetrain;

    public static OI oi;

    public Robot() {
        super();
        drivetrain = Drivetrain.create();
        oi = new OI();
    }

    @Override
    public void robotInit() {
        oi = new OI();
    }

    @Override
    public void robotPeriodic() {

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    
    }

    @Override
    public void autonomousPeriodic() { 
      Scheduler.getInstance().run(); 
    }

    @Override
    public void teleopInit() {
        
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {}

}