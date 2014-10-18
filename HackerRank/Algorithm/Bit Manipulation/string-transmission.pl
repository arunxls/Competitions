#!/usr/bin/perl
use strict;
use warnings;
use bignum;
use feature 'say';

sub distance_from_root{
    my ($n,$r,$e) = @_;
    my @num = split(//,$n);
    my @root = split(//,$r);
    my $count = 0;

    map {$count++ if((int($root[$_]) ^ int($num[$_])))} (0..$#root);
    return $count;
}

sub periodic{
    my $n = $_[0];
    my @num = split(//,$n);

    return 0 if($#num == 0);
    my @circular = @num;
    foreach (1..$#num){
        @circular = circular(@circular);
        return 1 if(join('',@num) == join('',@circular));
    }
    return 0;
}

sub circular{
    (return $_[$#_],@_[0..($#_-1)]);
}

sub range {
    my $bits = shift;

    my $num = '';
    my $stop = '1'x $bits;
    while($num != $stop){

    }
}

# # Tail starts here
# my $testcases = <>;
# for (1..$testcases){
#     my $i = <>;
#     chomp $i;
#     my ($bits,$errors) = split(/\s/,$i);

#     my $r = <>;
#     chomp $r;
#     say scalar (grep {! periodic($_) }  grep {! (distance_from_root($_,$r,$errors) > $errors) } range($bits))%1000000007;
# }

say periodic('1010101');