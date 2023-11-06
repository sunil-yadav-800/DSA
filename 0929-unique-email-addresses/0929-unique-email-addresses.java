class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<emails.length;i++)
        {
            String formattedEmail = formatEmail(emails[i]);
            set.add(formattedEmail);
        }
        return set.size();
    }
    public String formatEmail(String email)
    {
        String[] splitedEmail = email.split("@");
        String localName = splitedEmail[0];
        String domainName = splitedEmail[1];
        localName = localName.replace(".","");
        String[] splitPlus = localName.split("\\+");
        localName = splitPlus[0];
        return localName+"@"+domainName;
    }
}