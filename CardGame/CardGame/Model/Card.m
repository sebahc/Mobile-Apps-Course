//
//  Card.m
//  CardGame
//
//  Created by sebahc on 9/2/14.
//  Copyright (c) 2014 Sebastian J Herrera Cano. All rights reserved.
//

#import "Card.h"

@implementation Card

- (int)match:(Card *)card
{
    int score=0;
    
    
    if([card.contents isEqualToString:self.contents]){
        score=1;
    }
    
    
    return score;
    
    
}

@end
