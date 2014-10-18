#!/usr/bin/perl
use strict;
use warnings;

sub keyword
{
	my ($keyword,$input) = @_;

	my $map = get_keyword_map($keyword);

	my $output = '';

	foreach my $block (split(' ',$input))
	{
		foreach my $alphabet (split('',$block))
		{
			$output .= $map->{$alphabet};
		}
		$output .= ' ';
	}

	return $output;
}

sub get_keyword_map
{
	my $key = shift;
	my $map = {};

	my @all_alphabets = qw(A B C D E F G H I J K L M N O P Q R S T U V W X Y Z);
	my @new_key = remove_dup($key);
	my $size = scalar @new_key;

	my $hash = {map { $_ => [$_] } @new_key};

	my $index = 0;
	foreach my $a (@all_alphabets)
	{
		if (!defined $hash->{$a})
		{
			push(@{$hash->{$new_key[($index)%($size)]}},$a);
			$index++;
		}
	}

	my @array = ();
	foreach my $key (sort keys %{$hash})
	{
		@array = (@array,@{$hash->{$key}});
	}

	foreach (0..$#all_alphabets)
	{
		$map->{$array[$_]} = $all_alphabets[$_];
	}
	return $map;
}

sub remove_dup
{
	my $key = shift;

	my %key_hash = ();
	my @output = ();
	foreach my $a (split('',$key))
	{
		if(!defined $key_hash{$a}){
			$key_hash{$a} = 1;
			push (@output,$a);
		}
	}
	return @output;
}

#Tail starts here
my $test_cases = <>;
for (my $index = 0; $index < $test_cases; $index++)
{
    my $keyword = <>;
    chomp $keyword;
    my $input = <>;
    chomp $input;

    print keyword($keyword,$input);
    print "\n";  
}

# print keyword('SPORT','LDXTW KXDTL NBSFX BFOII LNBHG ODDWN BWK');