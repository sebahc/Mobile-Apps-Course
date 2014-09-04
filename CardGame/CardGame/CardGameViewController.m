//
//  CardGameViewController.m
//  CardGame
//
//  Created by sebahc on 9/2/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import "CardGameViewController.h"

@interface CardGameViewController ()
@property (weak, nonatomic) IBOutlet UILabel *flipsLabel;
@property(nonatomic) int flipcount;

@end

@implementation CardGameViewController

-(void) setFlipcount:(int)flipcount{
    _flipcount=flipcount;
    self.flipsLabel.text=[NSString stringWithFormat:@"Flips: %d",self.flipcount];
}


- (IBAction)touchCardButton:(UIButton *)sender {
    
    if ([sender.currentTitle length]){
        UIImage *cardImage = [UIImage imageNamed:@"cardback"];
        [sender setBackgroundImage:cardImage forState:UIControlStateNormal];
        [sender setTitle:@"" forState:UIControlStateNormal];
        
    } else{
        UIImage *cardImage = [UIImage imageNamed:@"cardfront"];
        [sender setBackgroundImage:cardImage forState:UIControlStateNormal];
        [sender setTitle:@"A♣︎" forState:UIControlStateNormal];
        
    }
    self.flipcount++;
    

    
    
    
}


@end
