import {Grid} from "@hilla/react-components/Grid";
import {GridColumn} from "@hilla/react-components/GridColumn";
import AccountRecord from "Frontend/generated/com/nickthecloudguy/services/CustomerService/AccountRecord"
import { useEffect, useState } from "react";

interface AccountsViewProps {
    accounts: AccountRecord[] | null;
}

export default function AccountsView(props: AccountsViewProps) {

    const balanceRenderer = (balance: number) => (
        <span>$
          {(balance/100).toFixed(2)}
        </span>
      );

    return (
        <div>
            <h3 className="text-l m-0">Accounts</h3>
            <Grid
                items={props.accounts}>
                <GridColumn path="id" header="Account ID" />
                <GridColumn path="accountType" header="Type" />
                <GridColumn header="Balance">
                    {({ item }) => balanceRenderer(item.balance)}
                </GridColumn>
                <GridColumn path="accountStatus" header="Status" />
            </Grid>
        </div>
    );
}
