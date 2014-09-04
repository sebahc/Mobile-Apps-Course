//
//  Card.m
//  Matchismo
//

#import "Card.h"

@implementation Card

// getter and setter of property was done by objetive-c

- (int)match:(NSArray *)otherCards;
{
    int score=0;
    
    for (Card *card in otherCards) {
        if ([card.contents isEqualToString:self.contents]){
            score=1;
        }
    }
    
    return score;
}


@end
