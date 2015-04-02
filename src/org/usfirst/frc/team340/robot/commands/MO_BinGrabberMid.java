package org.usfirst.frc.team340.robot.commands;

//import org.usfirst.frc.team340.robot.RobotMap;

/**
 *
 */
public class MO_BinGrabberMid extends CommandBase {

    public MO_BinGrabberMid() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(binGrabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[MO_BinGrabberMid: initialize] Called");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	binGrabber.midGrabber();
    	System.out.println("[MO_BinGrabberMid: initialize] Raised Grabber at speed specified in RobotMap");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[MO_BinGrabberMid: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[MO_BinGrabberMid: interrupted] called");
    }
}
